package pl.hetman.wiktoria.solvd.service.abstractfactory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.hetman.wiktoria.solvd.exceptions.ToyShopException;
import pl.hetman.wiktoria.solvd.service.impl.EmployeeEmailServiceImpl;
import pl.hetman.wiktoria.solvd.service.impl.SupplierEmailServiceImpl;

public class FactoryGenerator {

    private static final Logger LOGGER = LogManager.getLogger(FactoryGenerator.class);

    private static final String CONTACT = "CONTACT";
    private static final String SUPPLY = "SUPPLY";

    private final EmployeeEmailServiceImpl employeeEmailService;
    private final SupplierEmailServiceImpl supplierEmailService;

    public FactoryGenerator(EmployeeEmailServiceImpl employeeEmailService, SupplierEmailServiceImpl supplierEmailService) {
        this.employeeEmailService = employeeEmailService;
        this.supplierEmailService = supplierEmailService;
    }

    public AbstractFactory getFactory(String choice) throws ToyShopException {
        LOGGER.info("getFactory(" + choice + "))");
        switch (choice) {
            case CONTACT:
                LOGGER.info("getFactory(...))");
                return new ContactFactory(employeeEmailService, supplierEmailService);
            case SUPPLY:
                LOGGER.info("getFactory(...))");
                return new SupplyInfoFactory();
            default:
                LOGGER.warn("Can't create a factory. Invalid choice.");
                throw new ToyShopException("Can't create a factory. Invalid choice.");
        }
    }
}
