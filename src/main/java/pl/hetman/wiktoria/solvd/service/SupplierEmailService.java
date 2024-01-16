package pl.hetman.wiktoria.solvd.service;

import pl.hetman.wiktoria.solvd.exceptions.ToyShopException;
import pl.hetman.wiktoria.solvd.model.SupplierContactEmail;

import java.util.Optional;

public interface SupplierEmailService {
    Optional<SupplierContactEmail> findById(Long id) throws ToyShopException;
}
