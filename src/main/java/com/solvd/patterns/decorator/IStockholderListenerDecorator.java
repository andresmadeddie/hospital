package com.solvd.patterns.decorator;

public abstract class IStockholderListenerDecorator implements IStockholderListener {
    protected final IStockholderListener IStockholderListener;

    public IStockholderListenerDecorator(IStockholderListener IStockholderListener) {
        this.IStockholderListener = IStockholderListener;
    }
}