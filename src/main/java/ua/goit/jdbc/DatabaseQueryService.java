package ua.goit.jdbc;

import ua.goit.jdbc.model.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DatabaseQueryService {

    private final Database database = new Database();

    public List<MaxProjectCountClient> findMaxProjectsClient() throws IOException {

        List<MaxProjectCountClient> maxProjectCountClients = new ArrayList<>();
        String sqlFilePath = Objects.requireNonNull(DatabaseQueryService.class
                        .getClassLoader()
                        .getResource("sql/find_max_projects_client.sql"))
                .getPath();
        String sql = readSQLFile(sqlFilePath);
        try (
                Connection connection = database.getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql)
        ) {
            while (resultSet.next()) {
                MaxProjectCountClient maxProjectCountClient = new MaxProjectCountClient();
                maxProjectCountClient.setName(resultSet.getString("NAME"));
                maxProjectCountClient.setProjectCount(resultSet.getInt("PROJECT_COUNT"));
                maxProjectCountClients.add(maxProjectCountClient);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return maxProjectCountClients;

    }

    public List<MaxSalaryWorker> findMaxSalaryWorker() throws IOException {
        List<MaxSalaryWorker> maxSalaryWorkers = new ArrayList<>();
        String sqlFilePath = Objects.requireNonNull(DatabaseQueryService.class
                        .getClassLoader()
                        .getResource("sql/find_max_salary_worker.sql"))
                .getPath();
        String sql = readSQLFile(sqlFilePath);

        try (
                Connection connection = database.getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql)
        ) {

            while (resultSet.next()) {
                MaxSalaryWorker maxSalaryWorker = new MaxSalaryWorker();
                maxSalaryWorker.setName(resultSet.getString("NAME"));
                maxSalaryWorker.setSalary(resultSet.getInt("SALARY"));
                maxSalaryWorkers.add(maxSalaryWorker);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return maxSalaryWorkers;
    }

    public List<YoungEldestWorker> findYongEldestWorker() throws IOException {
        List<YoungEldestWorker> youngEldestWorkers = new ArrayList<>();
        String sqlFilePath = Objects.requireNonNull(DatabaseQueryService.class
                        .getClassLoader()
                        .getResource("sql/find_youngest_eldest_workers.sql"))
                .getPath();
        String sql = readSQLFile(sqlFilePath);

        try (
                Connection connection = database.getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql)
        ) {
            while (resultSet.next()) {
                YoungEldestWorker youngEldestWorker = new YoungEldestWorker();
                youngEldestWorker.setType(resultSet.getString("TYPE"));
                youngEldestWorker.setName(resultSet.getString("NAME"));
                youngEldestWorker.setBirthday(resultSet.getDate("BIRTHDAY"));
                youngEldestWorkers.add(youngEldestWorker);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return youngEldestWorkers;
    }

    public List<LongestProject> findLongestProject() throws IOException {
        List<LongestProject> longestProjects = new ArrayList<>();
        String sqlFilePath = Objects.requireNonNull(DatabaseQueryService.class
                        .getClassLoader()
                        .getResource("sql/find_longest_project.sql"))
                .getPath();
        String sql = readSQLFile(sqlFilePath);

        try (
                Connection connection = database.getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql)
        ) {
            while (resultSet.next()) {
                LongestProject longestProject = new LongestProject();
                longestProject.setName(resultSet.getString("NAME"));
                longestProject.setMonthCount(resultSet.getInt("MONTH_COUNT"));
                longestProjects.add(longestProject);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return longestProjects;
    }

    public List<PrintProjectPrice> printProjectPrice() throws IOException {
        List<PrintProjectPrice> printProjectPrices = new ArrayList<>();
        String sqlFilePath = Objects.requireNonNull(DatabaseQueryService.class
                        .getClassLoader()
                        .getResource("sql/print_project_prices.sql"))
                .getPath();
        String sql = readSQLFile(sqlFilePath);

        try (
                Connection connection = database.getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql)
        ) {
            while (resultSet.next()) {
                PrintProjectPrice printProjectPrice = new PrintProjectPrice();
                printProjectPrice.setName(resultSet.getString("NAME"));
                printProjectPrice.setPrice(resultSet.getInt("PRICE"));
                printProjectPrices.add(printProjectPrice);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return printProjectPrices;
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

}
