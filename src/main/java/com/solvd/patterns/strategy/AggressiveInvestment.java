package com.solvd.patterns.strategy;

public class AggressiveInvestment implements InvestmentStrategy {
    @Override
    public void invest() {
        System.out.println("Investing aggressively.");
    }
}