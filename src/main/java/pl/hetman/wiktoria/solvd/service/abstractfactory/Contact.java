package pl.hetman.wiktoria.solvd.service.abstractfactory;

import pl.hetman.wiktoria.solvd.exceptions.ContactException;
import pl.hetman.wiktoria.solvd.exceptions.ToyShopException;

import java.util.Optional;

public interface Contact<T> {
    Optional<T> findContact(Long id) throws ContactException, ToyShopException;
}
