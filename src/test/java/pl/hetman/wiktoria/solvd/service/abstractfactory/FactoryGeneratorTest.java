package pl.hetman.wiktoria.solvd.service.abstractfactory;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.hetman.wiktoria.solvd.exceptions.ContactException;
import pl.hetman.wiktoria.solvd.exceptions.SupplyException;
import pl.hetman.wiktoria.solvd.exceptions.ToyShopException;
import pl.hetman.wiktoria.solvd.persistence.impl.EmployeeEmailRepoMyBatisImpl;
import pl.hetman.wiktoria.solvd.persistence.impl.SupplierEmailRepositoryImpl;
import pl.hetman.wiktoria.solvd.service.impl.EmployeeEmailServiceImpl;
import pl.hetman.wiktoria.solvd.service.impl.SupplierEmailServiceImpl;

import static org.junit.jupiter.api.Assertions.*;

class FactoryGeneratorTest {

    private static final String CONTACT = "CONTACT";
    private static final String SUPPLY = "SUPPLY";
    private static final String EMPLOYEE = "EMPLOYEE";
    private static final String SUPPLIER = "SUPPLIER";
    public static final String TOY_SUPPLY = "TOY SUPPLY";
    public static final String TOY_SUPPLIER = "TOY SUPPLIER";

    @Test
    void validateAbstractFactory() throws ToyShopException, ContactException, SupplyException {
        //given
        EmployeeEmailRepoMyBatisImpl employeeEmailRepoMyBatis = new EmployeeEmailRepoMyBatisImpl();
        SupplierEmailRepositoryImpl supplierEmailRepository = new SupplierEmailRepositoryImpl();
        EmployeeEmailServiceImpl employeeEmailService = new EmployeeEmailServiceImpl(employeeEmailRepoMyBatis);
        SupplierEmailServiceImpl supplierEmailService = new SupplierEmailServiceImpl(supplierEmailRepository);
        FactoryGenerator factoryGenerator = new FactoryGenerator(employeeEmailService, supplierEmailService);

        //when
        AbstractFactory factoryContact = factoryGenerator.getFactory(CONTACT);
        Contact contactEmployee = factoryContact.getContact(EMPLOYEE);
        Contact contactSupplier = factoryContact.getContact(SUPPLIER);
        AbstractFactory factorySupply = factoryGenerator.getFactory(SUPPLY);
        SupplyInfo toySupplyInfo = factorySupply.getSupplyInfo(TOY_SUPPLY);
        SupplyInfo toySupplierInfo = factorySupply.getSupplyInfo(TOY_SUPPLIER);

        //both are not present yet, need implementation
        boolean isToySupplyInfoPresent = toySupplyInfo.getSupplyInfo().isPresent();
        boolean isToySupplierInfoPresent = toySupplierInfo.getSupplyInfo().isPresent();

        //then
        Assertions.assertAll(
                ()-> Assertions.assertNotNull(contactEmployee, "contactEmployee is null"),
                ()-> Assertions.assertNotNull(contactSupplier, "contactSupplier is null"),
                ()-> Assertions.assertFalse(isToySupplyInfoPresent, "isToySupplyInfoPresent is present"),
                ()-> Assertions.assertFalse(isToySupplierInfoPresent, "isToySupplierInfoPresent is present")
        );

    }
}