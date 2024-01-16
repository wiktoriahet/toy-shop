package pl.hetman.wiktoria.solvd.service.impl;

import pl.hetman.wiktoria.solvd.exceptions.ToyShopException;
import pl.hetman.wiktoria.solvd.model.SupplierContactEmail;
import pl.hetman.wiktoria.solvd.persistence.impl.SupplierEmailRepositoryImpl;
import pl.hetman.wiktoria.solvd.service.SupplierEmailService;

import java.util.Optional;

public class SupplierEmailServiceImpl implements SupplierEmailService {

    private final SupplierEmailRepositoryImpl supplierEmailRepository;

    public SupplierEmailServiceImpl(SupplierEmailRepositoryImpl supplierEmailRepository) {
        this.supplierEmailRepository = supplierEmailRepository;
    }

    @Override
    public Optional<SupplierContactEmail> findById(Long id) throws ToyShopException {
        if (id == null) {
            throw new ToyShopException("Can't find EmployeeContactEmail, id is null ");
        } else {
            Optional<SupplierContactEmail> foundedSupplierEmail = supplierEmailRepository.findById(id);
            return foundedSupplierEmail;
        }
    }
}
