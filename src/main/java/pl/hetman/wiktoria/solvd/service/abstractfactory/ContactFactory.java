package pl.hetman.wiktoria.solvd.service.abstractfactory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.hetman.wiktoria.solvd.exceptions.ContactException;
import pl.hetman.wiktoria.solvd.service.SupplierEmailService;
import pl.hetman.wiktoria.solvd.service.impl.EmployeeEmailServiceImpl;

public class ContactFactory extends AbstractFactory {

    private static final Logger LOGGER = LogManager.getLogger(ContactFactory.class);

    private static final String EMPLOYEE = "EMPLOYEE";
    private static final String SUPPLIER = "SUPPLIER";

    private final EmployeeEmailServiceImpl employeeEmailService;
    private final SupplierEmailService supplierEmailService;

    public ContactFactory(EmployeeEmailServiceImpl employeeEmailService, SupplierEmailService supplierEmailService) {
        this.employeeEmailService = employeeEmailService;
        this.supplierEmailService = supplierEmailService;
    }

    @Override
    Contact getContact(String type) throws ContactException {
        LOGGER.info("getContact(" + type + ")");
        switch (type) {
            case EMPLOYEE:
                LOGGER.info("getContact(...)");
                return new EmployeeContactInfo(employeeEmailService);
            case SUPPLIER:
                LOGGER.info("getContact(...)");
                return new SupplierContactInfo(supplierEmailService);
            default:
                LOGGER.warn("Can't get contact. Invalid type.");
                throw new ContactException("Can't get contact. Invalid type.");
        }
    }

    @Override
    SupplyInfo getSupplyInfo(String type) {
        return null;
    }
}
