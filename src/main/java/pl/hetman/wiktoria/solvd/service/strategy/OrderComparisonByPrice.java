package pl.hetman.wiktoria.solvd.service.strategy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.hetman.wiktoria.solvd.model.Order;
import pl.hetman.wiktoria.solvd.model.OrderPrice;

public class OrderComparisonByPrice implements Strategy{

    private static final Logger LOGGER = LogManager.getLogger(OrderComparisonByPrice.class);

    @Override
    public boolean orderComparision(Order firstOrder, Order secondOrder) {
        LOGGER.info("orderComparision(" + firstOrder + ", " + secondOrder + ")");
        OrderPrice firstOrderPrice = new OrderPrice();
        firstOrderPrice.setOrderId(firstOrder.getId());
        //checking orderPrice in database
        OrderPrice secondOrderPrice = new OrderPrice();
        secondOrderPrice.setOrderId(secondOrder.getId());
        //checking orderPrice in database
        LOGGER.info("orderComparision(...)");
        return firstOrderPrice.getPrice().equals(secondOrderPrice.getPrice());
    }
}
