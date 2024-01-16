package pl.hetman.wiktoria.solvd.service.strategy;

import pl.hetman.wiktoria.solvd.model.Order;
import pl.hetman.wiktoria.solvd.model.OrderPrice;

public class OrderComparisonByPrice implements Strategy{

    @Override
    public boolean orderComparision(Order firstOrder, Order secondOrder) {
        OrderPrice firstOrderPrice = new OrderPrice();
        firstOrderPrice.setOrderId(firstOrder.getId());
        //checking orderPrice in database
        OrderPrice secondOrderPrice = new OrderPrice();
        secondOrderPrice.setOrderId(secondOrder.getId());
        //checking orderPrice in database
        return firstOrderPrice.getPrice().equals(secondOrderPrice.getPrice());
    }
}
