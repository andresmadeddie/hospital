package com.solvd.patterns.strategy;

public class ConservativeInvestment implements InvestmentStrategy {
    @Override
    public void invest() {
        System.out.println("Investing conservatively.");
    }
}