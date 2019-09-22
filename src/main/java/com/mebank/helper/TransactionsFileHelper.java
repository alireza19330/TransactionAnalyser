package com.mebank.helper;

import com.mebank.dto.Transaction;

import java.io.BufferedReader;
import java.io.FileReader;
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
        //TODO implement the parse
        return null;
    }

}
