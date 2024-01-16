package pl.hetman.wiktoria.solvd.persistence;

import pl.hetman.wiktoria.solvd.exceptions.ToyShopException;
import pl.hetman.wiktoria.solvd.model.Discount;

import java.util.Optional;

public interface DiscountRepository {
    Optional<Discount> findById(Long id) throws ToyShopException;
}
