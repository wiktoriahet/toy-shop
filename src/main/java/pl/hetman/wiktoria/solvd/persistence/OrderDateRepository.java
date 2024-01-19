package pl.hetman.wiktoria.solvd.persistence;

import pl.hetman.wiktoria.solvd.exceptions.ToyShopException;
import pl.hetman.wiktoria.solvd.model.OrderDate;

import java.util.Optional;

public interface OrderDateRepository {
    Optional<OrderDate> findById(Long id) throws ToyShopException;
}
