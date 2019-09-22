package com.mebank.service;

import java.math.BigDecimal;

public class RelativeBalanceResponse {

    private BigDecimal balance;
    private int numOfRecords;

    public RelativeBalanceResponse(BigDecimal balance, int numOfRecords) {
        this.balance = balance;
        this.numOfRecords = numOfRecords;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public int getNumOfRecords() {
        return numOfRecords;
    }
}
