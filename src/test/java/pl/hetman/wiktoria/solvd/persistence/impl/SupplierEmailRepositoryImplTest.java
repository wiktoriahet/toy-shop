package pl.hetman.wiktoria.solvd.persistence.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.hetman.wiktoria.solvd.exceptions.ToyShopException;
import pl.hetman.wiktoria.solvd.model.SupplierContactEmail;

import java.util.Optional;

class SupplierEmailRepositoryImplTest {

    @Test
    void findById() throws ToyShopException {
        //given
        SupplierEmailRepositoryImpl supplierEmailRepository = new SupplierEmailRepositoryImpl();

        //when
        Optional<SupplierContactEmail> foundedEmail = supplierEmailRepository.findById(1L);

        //then
        Assertions.assertTrue(foundedEmail.isPresent(), "foundedEmail is not present");

    }
}