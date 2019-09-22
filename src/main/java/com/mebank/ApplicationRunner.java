package com.mebank;

import com.mebank.service.RelativeBalanceResponse;
import com.mebank.service.RelativeBalanceService;

public class ApplicationRunner {

    public static void main(String[] args) {

        RelativeBalanceService relativeBalanceService = new RelativeBalanceService();
        RelativeBalanceResponse balance = relativeBalanceService.getBalance("/Users/aabazari/Downloads/mine/TransactionsAnalyser/src/main/resources/input.csv", "20/10/2018 12:00:00", "20/10/2018 19:00:00", "ACC334455");
        System.out.println("Relative balance for the period is: " + balance.getBalance() + "\nNumber of transactions included is: " + balance.getNumOfRecords());

    }
}
