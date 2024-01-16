package pl.hetman.wiktoria.solvd.service.strategy;

import pl.hetman.wiktoria.solvd.model.Order;

public class Context {

    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public boolean executeStrategy(Order firstOrder, Order secondOrder){
        return strategy.orderComparision(firstOrder, secondOrder);
    }
}
