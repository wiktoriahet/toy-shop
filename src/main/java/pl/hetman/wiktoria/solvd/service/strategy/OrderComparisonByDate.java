package pl.hetman.wiktoria.solvd.service.strategy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.hetman.wiktoria.solvd.model.Order;
import pl.hetman.wiktoria.solvd.model.OrderDate;

public class OrderComparisonByDate implements Strategy{

    private static final Logger LOGGER = LogManager.getLogger(OrderComparisonByDate.class);
    @Override
    public boolean orderComparision(Order firstOrder, Order secondOrder) {
        LOGGER.info("orderComparision(" + firstOrder + ", " + secondOrder + ")");
        OrderDate firstOrderDate = new OrderDate();
        firstOrderDate.setOrderId(firstOrder.getId());
        //checking orderDate in database
        OrderDate secondOrderDate = new OrderDate();
        secondOrderDate.setOrderId(secondOrder.getId());
        //checking orderDate in database
        LOGGER.info("orderComparision(...)");
        return firstOrderDate.getDate().isEqual(secondOrderDate.getDate());
    }
}
