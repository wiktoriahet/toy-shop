package pl.hetman.wiktoria.solvd.service.factory;

import pl.hetman.wiktoria.solvd.exceptions.OfferException;
import pl.hetman.wiktoria.solvd.exceptions.ToyShopException;

import java.util.Optional;

public interface Offer<T> {
    Optional<T> makeOffer(Long id) throws OfferException, ToyShopException;
}
