package ua.goit.jdbc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;


public class DatabaseInitService {
    public static void main(String[] args) {
        try (Connection connection = Database.getInstance().getConnection();) {
            if (connection != null) {
                String sqlFilePath = Objects.requireNonNull(DatabaseInitService.class
                                .getClassLoader()
                                .getResource("sql/init_db.sql"))
                        .getPath();
                try {
                    String sql = readSQLFile(sqlFilePath);
                    executeSQL(connection, sql);
                    System.out.println("Database initialized successfully");
                } catch (IOException e) {
                    System.out.println("Failed to read SQL file: " + sqlFilePath);
                    e.printStackTrace();
                } catch (SQLException e) {
                    System.out.println("Failed to execute SQL");
                    e.printStackTrace();
                }
            } else {
                System.out.println("Failed to connect to database.");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private static String readSQLFile(String filePath) throws IOException {
        StringBuilder sql = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                sql.append(line).append("\n");
            }
        }
        return sql.toString();
    }

    private static void executeSQL(Connection connection, String sql) throws SQLException {
        try (
                Statement statement = connection.createStatement();) {
            statement.execute(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
