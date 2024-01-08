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

    @Test
    void checkFindById() throws ToyShopException {
        //given
        EmployeeEmailMyBatisImpl employeeEmailRepo = new EmployeeEmailMyBatisImpl();
        EmployeeEmailServiceImpl employeeEmailService = new EmployeeEmailServiceImpl(employeeEmailRepo);

        //when
        Optional<EmployeeContactEmail> foundedEmployeeEmail = employeeEmailService.findById(10L);
        List<Email> emails = foundedEmployeeEmail.orElse(null).getEmails();
        Email email = emails.get(0);
        String emailName = email.getEmail();
        System.out.println(emailName);

        //then
        Assertions.assertNotNull(foundedEmployeeEmail, "foundedEmployeeEmail is null");

    }
}