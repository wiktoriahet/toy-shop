package pl.hetman.wiktoria.solvd.service;

import pl.hetman.wiktoria.solvd.exceptions.ToyShopException;
import pl.hetman.wiktoria.solvd.model.OrderPrice;

import java.util.Optional;

public interface OrderPriceService {
    Optional<OrderPrice> findById(Long id) throws ToyShopException;
}
