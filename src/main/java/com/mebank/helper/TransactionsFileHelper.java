package com.mebank.helper;

import com.mebank.dto.Transaction;
import com.mebank.dto.TransactionType;

import java.io.BufferedReader;
import java.io.FileReader;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TransactionsFileHelper {

    public static List<Transaction> readTransactionsFromFile(String path, boolean includeHeader){
        Scanner fileScanner = null;
        try{
            fileScanner = new Scanner(new BufferedReader(new FileReader(path)));
            List<String> rawTransactions = new ArrayList<>();
            while (fileScanner.hasNext()){
                rawTransactions.add(fileScanner.nextLine());
            }
            return parseToTransactions(rawTransactions, includeHeader);
        } catch (Exception e){
            //TODO add log here
            return null;
        } finally {
            if (fileScanner != null){
                fileScanner.close();
            }
        }
    }

    private static List<Transaction> parseToTransactions(List<String> rawTransactions, boolean includeHeader) {
        List<Transaction> result = new ArrayList();
        if (includeHeader){
            rawTransactions.remove(0);
        }
        for (String line: rawTransactions) {
            String[] split = line.split(",");
            //TODO input validation should be added
            Transaction transaction = new Transaction(split[0], split[1], split[2], ConversionUtil.stringToDate(split[3]), new BigDecimal(split[4]), split[6].equals(TransactionType.PAYMENT.getValue()) ? TransactionType.PAYMENT : TransactionType.REVERSAL, split[7]);
            result.add(transaction);
        }
        return result;
    }

}
