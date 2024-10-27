package com.solvd.patterns.listener;

import java.util.ArrayList;
import java.util.List;

public class StockholderEventManager {
    private final List<StockholderListener> listeners = new ArrayList<>();

    public void addListener(StockholderListener listener) {
        listeners.add(listener);
    }

    public void notifyListeners(String message) {
        StockholderEvent event = new StockholderEvent(message);
        for (StockholderListener listener : listeners) {
            listener.onEvent(event);
        }
    }
}
