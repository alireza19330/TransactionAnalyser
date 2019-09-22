package com.mebank.dto;

public enum TransactionType {

    PAYMENT("PAYMENT"),
    REVERSAL("REVERSAL");

    private String  value;

    TransactionType(String value) {
        this.value = value;
    }
}
