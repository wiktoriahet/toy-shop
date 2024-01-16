package pl.hetman.wiktoria.solvd.service;

import pl.hetman.wiktoria.solvd.exceptions.ToyShopException;
import pl.hetman.wiktoria.solvd.model.Discount;

import java.util.Optional;

public interface DiscountService {
    Optional<Discount> findById(Long id) throws ToyShopException;
}
