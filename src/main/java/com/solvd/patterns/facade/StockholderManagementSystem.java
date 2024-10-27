package com.solvd.patterns.facade;

public class StockholderManagementSystem {
    public void addStockholder(String name, String email) {
        // Add stockholder logic
        System.out.println("Stockholder added: " + name);
    }

    public void notifyStockholders(String message) {
        // Notify stockholders logic
        System.out.println("Notifying stockholders: " + message);
    }

    public void generateReports() {
        // Generate stockholder reports
        System.out.println("Generating stockholder reports.");
    }
}
