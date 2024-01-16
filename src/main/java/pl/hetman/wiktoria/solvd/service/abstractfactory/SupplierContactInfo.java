package pl.hetman.wiktoria.solvd.service.abstractfactory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.hetman.wiktoria.solvd.exceptions.ContactException;
import pl.hetman.wiktoria.solvd.exceptions.ToyShopException;
import pl.hetman.wiktoria.solvd.model.SupplierContactEmail;
import pl.hetman.wiktoria.solvd.service.SupplierEmailService;

import java.util.Optional;

public class SupplierContactInfo implements Contact<SupplierContactEmail> {

    private static final Logger LOGGER = LogManager.getLogger(SupplierContactInfo.class);

    private final SupplierEmailService supplierEmailService;

    public SupplierContactInfo(SupplierEmailService supplierEmailService) {
        this.supplierEmailService = supplierEmailService;
    }

    @Override
    public Optional<SupplierContactEmail> findContact(Long id) throws ContactException, ToyShopException {
        LOGGER.info("findContact(" + id + ")");
        if (id == null) {
            LOGGER.warn("Can't find contact. Id is null.");
            throw new ContactException("Can't find contact. Id is null.");
        } else {
            LOGGER.info("findContact(...)");
            return supplierEmailService.findById(id);
        }
    }
}
