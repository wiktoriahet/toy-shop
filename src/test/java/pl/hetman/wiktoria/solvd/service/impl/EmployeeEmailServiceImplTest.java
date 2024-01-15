package pl.hetman.wiktoria.solvd.service.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.hetman.wiktoria.solvd.exceptions.ToyShopException;
import pl.hetman.wiktoria.solvd.model.Email;
import pl.hetman.wiktoria.solvd.model.EmployeeContactEmail;
import pl.hetman.wiktoria.solvd.persistence.impl.EmployeeEmailMyBatisImpl;

import java.util.List;
import java.util.Optional;

class EmployeeEmailServiceImplTest {

    static {
        System.setProperty("log4j.configurationFile", "log4j2.xml");
    }

    @Test
    void validateFindById() throws ToyShopException {
        //given
        EmployeeEmailMyBatisImpl employeeEmailRepo = new EmployeeEmailMyBatisImpl();
        EmployeeEmailServiceImpl employeeEmailService = new EmployeeEmailServiceImpl(employeeEmailRepo);

        //when
        Optional<EmployeeContactEmail> foundedEmployeeEmail = employeeEmailService.findById(10L);
        List<Email> emails = foundedEmployeeEmail.orElse(null) != null ? foundedEmployeeEmail.get().getEmails() : null;

        //then
        Assertions.assertAll(
                () -> Assertions.assertNotNull(foundedEmployeeEmail, "foundedEmployeeEmail is null"),
                () -> Assertions.assertNotNull(emails, "Emails list is null")
        );

    }
}