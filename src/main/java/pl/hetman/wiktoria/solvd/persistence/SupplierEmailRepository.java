package pl.hetman.wiktoria.solvd.persistence;

import pl.hetman.wiktoria.solvd.exceptions.ToyShopException;
import pl.hetman.wiktoria.solvd.model.SupplierContactEmail;

import java.util.Optional;

public interface SupplierEmailRepository {

    Optional<SupplierContactEmail> findById(Long id) throws ToyShopException;

}
