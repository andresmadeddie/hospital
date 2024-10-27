package com.solvd.patterns.listener;

public class StockholderEvent {
    private final String message;

    public StockholderEvent(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
