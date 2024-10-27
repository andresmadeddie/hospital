package com.solvd.patterns.decorator;

public class EmailNotificationDecorator extends IStockholderListenerDecorator {
    public EmailNotificationDecorator(IStockholderListener IStockholderListener) {
        super(IStockholderListener);
    }

    @Override
    public String getDetails() {
        return IStockholderListener.getDetails() + " - Email notifications enabled.";
    }
}
