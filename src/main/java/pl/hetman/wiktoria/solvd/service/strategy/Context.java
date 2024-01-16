package pl.hetman.wiktoria.solvd.service.strategy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.hetman.wiktoria.solvd.model.Order;

public class Context {

    private static final Logger LOGGER = LogManager.getLogger(Context.class);

    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public boolean executeStrategy(Order firstOrder, Order secondOrder) {
        LOGGER.info("executeStrategy(" + firstOrder + ", " + secondOrder + ")");
        LOGGER.info("executeStrategy(...)");
        return strategy.orderComparision(firstOrder, secondOrder);
    }
}
