package pl.hetman.wiktoria.solvd.service;

import pl.hetman.wiktoria.solvd.exceptions.ToyShopException;
import pl.hetman.wiktoria.solvd.model.OrderDate;

import java.util.Optional;

public interface OrderDateService {
    Optional<OrderDate> findById(Long id) throws ToyShopException;
}
