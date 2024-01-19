package pl.hetman.wiktoria.solvd.service.strategy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.hetman.wiktoria.solvd.exceptions.ToyShopException;
import pl.hetman.wiktoria.solvd.model.Order;
import pl.hetman.wiktoria.solvd.model.OrderDate;
import pl.hetman.wiktoria.solvd.service.impl.OrderDateServiceImpl;

public class OrderComparisonByDate implements Strategy{

    private static final Logger LOGGER = LogManager.getLogger(OrderComparisonByDate.class);

    private final OrderDateServiceImpl orderDateService;

    public OrderComparisonByDate(OrderDateServiceImpl orderDateService) {
        this.orderDateService = orderDateService;
    }

    @Override
    public boolean orderComparision(Order firstOrder, Order secondOrder) throws ToyShopException {
        LOGGER.info("orderComparision(" + firstOrder + ", " + secondOrder + ")");

        Long firstOrderId = firstOrder.getId();
        Long secondOrderId = secondOrder.getId();

        OrderDate firstOrderDate = orderDateService.findById(firstOrderId).orElse(null);
        OrderDate secondOrderDate = orderDateService.findById(secondOrderId).orElse(null);
        LOGGER.info("orderComparision(...)");
        return firstOrderDate.getDate().isEqual(secondOrderDate.getDate());
    }
}
