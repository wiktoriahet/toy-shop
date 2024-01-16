package pl.hetman.wiktoria.solvd.service.strategy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.hetman.wiktoria.solvd.model.Order;

public class OrderComparisonByCustomer implements Strategy {

    private static final Logger LOGGER = LogManager.getLogger(OrderComparisonByCustomer.class);

    @Override
    public boolean orderComparision(Order firstOrder, Order secondOrder) {
        LOGGER.info("orderComparision(" + firstOrder + ", " + secondOrder + ")");
        LOGGER.info("orderComparision(...)");
        return firstOrder.getCustomerId() == secondOrder.getCustomerId();
    }
}
