package pl.hetman.wiktoria.solvd.service.strategy;

import pl.hetman.wiktoria.solvd.model.Order;

public class OrderComparisonByCustomer implements Strategy{
    @Override
    public boolean orderComparision(Order firstOrder, Order secondOrder) {
        return firstOrder.getCustomerId() == secondOrder.getCustomerId();
    }
}
