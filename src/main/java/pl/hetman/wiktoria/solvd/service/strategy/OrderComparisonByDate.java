package pl.hetman.wiktoria.solvd.service.strategy;

import pl.hetman.wiktoria.solvd.model.Order;
import pl.hetman.wiktoria.solvd.model.OrderDate;

public class OrderComparisonByDate implements Strategy{
    @Override
    public boolean orderComparision(Order firstOrder, Order secondOrder) {
        OrderDate firstOrderDate = new OrderDate();
        firstOrderDate.setOrderId(firstOrder.getId());
        //checking orderDate in database
        OrderDate secondOrderDate = new OrderDate();
        secondOrderDate.setOrderId(secondOrder.getId());
        //checking orderDate in database
        return firstOrderDate.getDate().isEqual(secondOrderDate.getDate());
    }
}
