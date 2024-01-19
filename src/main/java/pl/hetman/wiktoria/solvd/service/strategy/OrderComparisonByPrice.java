package pl.hetman.wiktoria.solvd.service.strategy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.hetman.wiktoria.solvd.exceptions.ToyShopException;
import pl.hetman.wiktoria.solvd.model.Order;
import pl.hetman.wiktoria.solvd.model.OrderPrice;
import pl.hetman.wiktoria.solvd.service.impl.OrderPriceServiceImpl;

public class OrderComparisonByPrice implements Strategy{

    private static final Logger LOGGER = LogManager.getLogger(OrderComparisonByPrice.class);

    private final OrderPriceServiceImpl orderPriceService;

    public OrderComparisonByPrice(OrderPriceServiceImpl orderPriceService) {
        this.orderPriceService = orderPriceService;
    }

    @Override
    public boolean orderComparision(Order firstOrder, Order secondOrder) throws ToyShopException {
        LOGGER.info("orderComparision(" + firstOrder + ", " + secondOrder + ")");

        Long firstOrderId = firstOrder.getId();
        Long secondOrderId = secondOrder.getId();

        OrderPrice firstOrderPrice = orderPriceService.findById(firstOrderId).orElse(null);
        OrderPrice secondOrderPrice = orderPriceService.findById(secondOrderId).orElse(null);
        LOGGER.info("orderComparision(...)");
        return firstOrderPrice.getPrice().equals(secondOrderPrice.getPrice());

    }
}
