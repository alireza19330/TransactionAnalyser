package com.mebank;

import com.mebank.service.RelativeBalanceResponse;
import com.mebank.service.RelativeBalanceService;

public class ApplicationRunner {

    public static void main(String[] args) {

        RelativeBalanceService relativeBalanceService = new RelativeBalanceService();
        String filePath = "/Users/aabazari/Downloads/mine/TransactionsAnalyser/src/main/resources/input.csv";
        String fromDateString = "20/10/2018 12:00:00";
        String toDateString = "20/10/2018 19:00:00";
        String account = "ACC334455";

        RelativeBalanceResponse balance = relativeBalanceService.getBalance(filePath, fromDateString, toDateString, account);
        String template = "Relative balance for the period is: %s\nNumber of transactions included is: %s";
        System.out.println(String.format(template, balance.getBalance(), balance.getNumOfRecords()));

    }
}
