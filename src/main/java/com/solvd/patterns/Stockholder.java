package com.solvd.patterns;

import com.solvd.patterns.decorator.IStockholderListener;
import com.solvd.patterns.listener.StockholderEvent;
import com.solvd.patterns.listener.StockholderListener;
import com.solvd.patterns.proxy.IStockholderProxy;
import com.solvd.patterns.strategy.InvestmentStrategy;

// Stockholder class
public class Stockholder  implements StockholderListener, IStockholderListener, IStockholderProxy {
    private final String name;
    private final String email;
    private final int shares;

    // For Strategy Pattern
    private InvestmentStrategy strategy;

    private Stockholder (Builder builder) {
        this.name = builder.name;
        this.email = builder.email;
        this.shares = builder.shares;
    }

    // For Strategy Pattern
    public void setInvestmentStrategy(InvestmentStrategy strategy) {
        this.strategy = strategy;
    }

    // For Strategy Pattern
    public void invest() {
        if (strategy != null) {
            strategy.invest();
        } else {
            System.out.println(name + " has no investment strategy set.");
        }
    }

    // For Listener Pattern
    @Override
    public void onEvent(StockholderEvent event) {
        System.out.println(name + " received event: " + event.getMessage());
    }

    // For Decorator Pattern
    @Override
    public String getDetails() {
        return "Stockholder: " + name;
    }

    // For Proxy Pattern
    @Override
    public String getName() {
        return name;
    }

    public static class Builder {
        private final String name; // required
        private String email; // optional
        private int shares; // optional

        public Builder(String name) {
            this.name = name;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder shares(int shares) {
            this.shares = shares;
            return this;
        }

        public Stockholder  build() {
            return new Stockholder (this);
        }
    }

    @Override
    public String toString() {
        return "Stockholder{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", shares=" + shares +
                '}';
    }
}
