package pl.hetman.wiktoria.solvd.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.hetman.wiktoria.solvd.exceptions.ToyShopException;
import pl.hetman.wiktoria.solvd.model.SupplierContactEmail;
import pl.hetman.wiktoria.solvd.persistence.impl.SupplierEmailRepositoryImpl;
import pl.hetman.wiktoria.solvd.service.SupplierEmailService;

import java.util.Optional;

public class SupplierEmailServiceImpl implements SupplierEmailService {

    private static final Logger LOGGER = LogManager.getLogger(SupplierEmailServiceImpl.class);

    private final SupplierEmailRepositoryImpl supplierEmailRepository;

    public SupplierEmailServiceImpl(SupplierEmailRepositoryImpl supplierEmailRepository) {
        this.supplierEmailRepository = supplierEmailRepository;
    }

    @Override
    public Optional<SupplierContactEmail> findById(Long id) throws ToyShopException {
        LOGGER.info("findById(" + id + ")");
        if (id == null) {
            LOGGER.warn("Can't find EmployeeContactEmail, id is null.");
            throw new ToyShopException("Can't find EmployeeContactEmail, id is null.");
        } else {
            Optional<SupplierContactEmail> foundedSupplierEmail = supplierEmailRepository.findById(id);
            LOGGER.info("findById(...)");
            return foundedSupplierEmail;
        }
    }
}
