package pl.hetman.wiktoria.solvd.persistence;

import pl.hetman.wiktoria.solvd.exceptions.ToyShopException;
import pl.hetman.wiktoria.solvd.model.OrderPrice;

import java.util.Optional;

public interface OrderPriceRepository {
    Optional<OrderPrice> findById(Long id) throws ToyShopException;
}
