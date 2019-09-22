package com.mebank.service;

import com.mebank.dto.Transaction;
import com.mebank.dto.TransactionType;
import com.mebank.helper.ConversionUtil;
import com.mebank.helper.TransactionsFileHelper;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class RelativeBalanceService {

    /**
     *
     * @param path the path of csv file including all transactions
     * @param fromDateString string in “DD/MM/YYYY hh:mm:ss” format
     * @param toDateString string in “DD/MM/YYYY hh:mm:ss” format
     * @param accountId
     * @return
     */
    public RelativeBalanceResponse getBalance(String path, String fromDateString, String toDateString, String accountId) {

        int numOfRecords = 0;
        BigDecimal balance = new BigDecimal(0);

        List<Transaction> transactions = TransactionsFileHelper.readTransactionsFromFile(path, true);

        Date fromDate = ConversionUtil.stringToDate(fromDateString);
        Date toDate = ConversionUtil.stringToDate(toDateString);

        List<Transaction> fromAccountTransactions = transactions.stream().filter( t -> (t.getTransactionType().equals(TransactionType.PAYMENT) && (t.getFromAccountId().equalsIgnoreCase(accountId) || t.getToAccountId().equalsIgnoreCase(accountId)) &&
                    t.getCreateAt().getTime() >= fromDate.getTime() && t.getCreateAt().getTime() <= toDate.getTime())).collect(Collectors.toList());
        List<String> rolledbackTransactionIds = transactions.stream().filter( t -> t.getTransactionType().equals(TransactionType.REVERSAL) &&
                t.getFromAccountId().equalsIgnoreCase(accountId)).map(reversal -> reversal.getRelatedTransaction()).collect(Collectors.toList());

        for (Transaction transaction : fromAccountTransactions) {
            if (rolledbackTransactionIds.contains(transaction.getTransactionId()))
                continue;
            numOfRecords++;
            balance = balance.add(transaction.getFromAccountId().equals(accountId) ? transaction.getAmount().negate() : transaction.getAmount());
        }

        return new RelativeBalanceResponse(balance, numOfRecords);
    }
}
