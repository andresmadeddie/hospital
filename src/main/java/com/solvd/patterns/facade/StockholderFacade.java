package com.solvd.patterns.facade;

public class StockholderFacade {
    private final StockholderManagementSystem managementSystem;

    public StockholderFacade() {
        this.managementSystem = new StockholderManagementSystem();
    }

    public void registerStockholder(String name, String email) {
        managementSystem.addStockholder(name, email);
    }

    public void alertStockholders(String message) {
        managementSystem.notifyStockholders(message);
    }

    public void createReport() {
        managementSystem.generateReports();
    }
}