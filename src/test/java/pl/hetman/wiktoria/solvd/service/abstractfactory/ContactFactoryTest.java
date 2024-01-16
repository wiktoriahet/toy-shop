package pl.hetman.wiktoria.solvd.service.abstractfactory;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.hetman.wiktoria.solvd.exceptions.ContactException;
import pl.hetman.wiktoria.solvd.persistence.impl.EmployeeEmailRepoMyBatisImpl;
import pl.hetman.wiktoria.solvd.persistence.impl.SupplierEmailRepositoryImpl;
import pl.hetman.wiktoria.solvd.service.impl.EmployeeEmailServiceImpl;
import pl.hetman.wiktoria.solvd.service.impl.SupplierEmailServiceImpl;

class ContactFactoryTest {

    private static final String EMPLOYEE = "EMPLOYEE";
    private static final String SUPPLIER = "SUPPLIER";

    @Test
    void validateContactFactory() throws ContactException {
        //given
        EmployeeEmailRepoMyBatisImpl employeeEmailRepoMyBatis = new EmployeeEmailRepoMyBatisImpl();
        EmployeeEmailServiceImpl employeeEmailService = new EmployeeEmailServiceImpl(employeeEmailRepoMyBatis);
        SupplierEmailRepositoryImpl supplierEmailRepository = new SupplierEmailRepositoryImpl();
        SupplierEmailServiceImpl supplierEmailService = new SupplierEmailServiceImpl(supplierEmailRepository);
        ContactFactory contactFactory = new ContactFactory(employeeEmailService, supplierEmailService);

        //when
        Contact employeeContact = contactFactory.getContact(EMPLOYEE);
        Contact supplierContact = contactFactory.getContact(SUPPLIER);

        //then
        Assertions.assertAll(
                () -> Assertions.assertNotNull(employeeContact, "employeeContact is null"),
                () -> Assertions.assertNotNull(supplierContact, "supplierContact is null")
        );

    }
}