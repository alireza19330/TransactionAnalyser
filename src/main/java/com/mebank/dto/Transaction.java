package com.mebank.dto;

import java.math.BigDecimal;

public class Transaction {

    private String transactionId;
    private String fromAccountId;
    private String toAccountId;
    private String createAt;
    private BigDecimal amount;
    private TransactionType transactionType;
    private String relatedTransaction;

    public Transaction(String transactionId, String fromAccountId, String toAccountId, String createAt, BigDecimal amount, TransactionType transactionType, String relatedTransaction) {
        this.transactionId = transactionId;
        this.fromAccountId = fromAccountId;
        this.toAccountId = toAccountId;
        this.createAt = createAt;
        this.amount = amount;
        this.transactionType = transactionType;
        this.relatedTransaction = relatedTransaction;
    }
}
