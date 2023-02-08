package ua.goit.jdbc;

import ua.goit.jdbc.model.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException, IOException {
        List<MaxProjectCountClient> maxProjectCountClients = new DatabaseQueryService().findMaxProjectsClient();
        System.out.println("\u001B[33m"+maxProjectCountClients+"\u001B[34m");
        List<MaxSalaryWorker> maxSalaryWorkers = new  DatabaseQueryService().findMaxSalaryWorker();
        System.out.println(maxSalaryWorkers+"\u001B[31m");
        List<YoungEldestWorker> yongEldestWorker = new DatabaseQueryService().findYongEldestWorker();
        System.out.println(yongEldestWorker+"\u001B[32m");
        List<LongestProject> longestProject = new DatabaseQueryService().findLongestProject();
        System.out.println(longestProject + "\u001B[36m");
        List<PrintProjectPrice> printProjectPrices = new DatabaseQueryService().printProjectPrice();
        System.out.println(printProjectPrices + "\u001B[0m");
    }
}
