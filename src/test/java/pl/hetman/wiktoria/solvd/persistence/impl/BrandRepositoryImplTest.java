package pl.hetman.wiktoria.solvd.persistence.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.hetman.wiktoria.solvd.model.Brand;

class BrandRepositoryImplTest {

    @Test
    void validateFindById() {
        //given
        BrandRepositoryImpl brandRepositoryImpl = new BrandRepositoryImpl();

        //when
        Brand foundBrand = brandRepositoryImpl.findById(3L).orElse(null);

        //then
        Assertions.assertNotNull(foundBrand, "foundToy is empty");

    }
}