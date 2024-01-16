package pl.hetman.wiktoria.solvd.service.abstractfactory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.hetman.wiktoria.solvd.exceptions.ContactException;
import pl.hetman.wiktoria.solvd.exceptions.ToyShopException;
import pl.hetman.wiktoria.solvd.model.EmployeeContactEmail;
import pl.hetman.wiktoria.solvd.service.impl.EmployeeEmailServiceImpl;

import java.util.Optional;

public class EmployeeContactInfo implements Contact<EmployeeContactEmail> {

    private static final Logger LOGGER = LogManager.getLogger(EmployeeContactInfo.class);

    private final EmployeeEmailServiceImpl employeeEmailService;

    public EmployeeContactInfo(EmployeeEmailServiceImpl employeeEmailService) {
        this.employeeEmailService = employeeEmailService;
    }

    @Override
    public Optional<EmployeeContactEmail> findContact(Long id) throws ContactException, ToyShopException {
        LOGGER.info("findContact(" + id + ")");
        if (id == null) {
            LOGGER.warn("Can't find contact. Id is null.");
            throw new ContactException("Can't find contact. Id is null.");
        } else {
            LOGGER.info("findContact(...)");
            return employeeEmailService.findById(id);
        }
    }
}
