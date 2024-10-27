package com.solvd.patterns.proxy;

import com.solvd.patterns.Stockholder;

public class StockholderProxy implements IStockholderProxy {
    private final Stockholder stockholder;

    public StockholderProxy(Stockholder real) {
        this.stockholder = real;
    }

    @Override
    public String getName() {
        System.out.println("Accessing name of stockholder through proxy.");
        return stockholder.getName();
    }
}