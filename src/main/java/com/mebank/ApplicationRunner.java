package com.mebank;

import com.mebank.service.RelativeBalanceResponse;
import com.mebank.service.RelativeBalanceService;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

public class ApplicationRunner {

    public static void main(String[] args) throws URISyntaxException {
        ApplicationRunner runner = new ApplicationRunner();
        runner.run(args);
    }

    private void run(String[] args) {
        RelativeBalanceService relativeBalanceService = new RelativeBalanceService();
        String filePath, fromDateString, toDateString, account;

        if (args == null || args.length == 0) {
            File file = new File(getClass().getResource("/input.csv").getFile());

            filePath = file.getAbsolutePath();
            account = "ACC334455";
            fromDateString = "20/10/2018 12:00:00";
            toDateString = "20/10/2018 19:00:00";
        } else {
            filePath = args[0];
            account = args[1];
            fromDateString = args[2];
            toDateString = args[3];
        }

        RelativeBalanceResponse balance = relativeBalanceService.getBalance(filePath, fromDateString, toDateString, account);
        String template = "Relative balance for the period is: %s\nNumber of transactions included is: %s";
        System.out.println(String.format(template, balance.getBalance(), balance.getNumOfRecords()));
    }
}
