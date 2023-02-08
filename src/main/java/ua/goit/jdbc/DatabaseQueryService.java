package ua.goit.jdbc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class DatabaseQueryService {

    private final Database database = new Database();

    public List<MaxProjectCountClient> findMaxProjectsClient() throws SQLException, IOException {

        List<MaxProjectCountClient> maxProjectCountClients = new ArrayList<>();
        String sqlFilePath = Objects.requireNonNull(DatabaseQueryService.class
                        .getClassLoader()
                        .getResource("sql/find_max_projects_client.sql"))
                .getPath();
        String sql = readSQLFile(sqlFilePath);
        try (
                Connection connection = database.getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
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

    public List<MaxSalaryWorker> findMaxSalaryWorker() throws IOException, SQLException {
        List<MaxSalaryWorker> maxSalaryWorkers = new ArrayList<>();
        String sqlFilePath = Objects.requireNonNull(DatabaseQueryService.class
                        .getClassLoader()
                        .getResource("sql/find_max_salary_worker.sql"))
                .getPath();
        String sql = readSQLFile(sqlFilePath);

        try (
                Connection connection = database.getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
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

    public List<YoungEldestWorker> findYongEldestWorker() throws IOException, SQLException {
        List<YoungEldestWorker> youngEldestWorkers = new ArrayList<>();
        String sqlFilePath = Objects.requireNonNull(DatabaseQueryService.class
                        .getClassLoader()
                        .getResource("sql/find_youngest_eldest_workers.sql"))
                .getPath();
        String sql = readSQLFile(sqlFilePath);

        try (
                Connection connection = database.getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
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

    public List<LongestProject> findLongestProject() throws IOException, SQLException {
        List<LongestProject> longestProjects = new ArrayList<>();
        String sqlFilePath = Objects.requireNonNull(DatabaseQueryService.class
                        .getClassLoader()
                        .getResource("sql/find_longest_project.sql"))
                .getPath();
        String sql = readSQLFile(sqlFilePath);

        try (
                Connection connection = database.getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
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

    public List<PrintProjectPrice> printProjectPrice() throws IOException, SQLException {
        List<PrintProjectPrice> printProjectPrices = new ArrayList<>();
        String sqlFilePath = Objects.requireNonNull(DatabaseQueryService.class
                        .getClassLoader()
                        .getResource("sql/print_project_prices.sql"))
                .getPath();
        String sql = readSQLFile(sqlFilePath);

        try (
                Connection connection = database.getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
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

    public static class MaxSalaryWorker {
        private String name;
        private int salary;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getSalary() {
            return salary;
        }

        public void setSalary(int salary) {
            this.salary = salary;
        }

        @Override
        public String toString() {
            return "MaxSalaryWorker{" +
                    "name='" + name + '\'' +
                    ", salary=" + salary +
                    '}';
        }
    }

    public static class MaxProjectCountClient {
        private String name;
        private int projectCount;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getProjectCount() {
            return projectCount;
        }

        public void setProjectCount(int projectCount) {
            this.projectCount = projectCount;
        }

        @Override
        public String toString() {
            return "MaxProjectCountClient{" +
                    "name='" + name + '\'' +
                    ", projectCount=" + projectCount +
                    '}';
        }
    }

    public static class YoungEldestWorker {
        private String type;
        private String name;
        private Date birthday;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Date getBirthday() {
            return birthday;
        }

        public void setBirthday(Date birthday) {
            this.birthday = birthday;
        }

        @Override
        public String toString() {
            return "YoungEldestWorker{" +
                    "type='" + type + '\'' +
                    ", name='" + name + '\'' +
                    ", birthday=" + birthday +
                    '}';
        }
    }

    public static class LongestProject {
        private String name;
        private int monthCount;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getMonthCount() {
            return monthCount;
        }

        public void setMonthCount(int monthCount) {
            this.monthCount = monthCount;
        }

        @Override
        public String toString() {
            return "LongestProject{" +
                    "name='" + name + '\'' +
                    ", monthCount=" + monthCount +
                    '}';
        }
    }

    public static class PrintProjectPrice {
        private String name;
        private int price;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        @Override
        public String toString() {
            return "PrintProjectPrices{" +
                    "name='" + name + '\'' +
                    ", price=" + price +
                    '}';
        }
    }
}
