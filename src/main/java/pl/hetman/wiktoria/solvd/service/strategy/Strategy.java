package pl.hetman.wiktoria.solvd.service.strategy;

import pl.hetman.wiktoria.solvd.exceptions.ToyShopException;
import pl.hetman.wiktoria.solvd.model.Order;

public interface Strategy {
    boolean orderComparision(Order firstOrder, Order secondOrder) throws ToyShopException;
}
