package pl.hetman.wiktoria.solvd.persistence.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.hetman.wiktoria.solvd.model.Brand;

class BrandRepositoryTest {

    @Test
    void checkFindById() {
        //given
        BrandRepository brandRepository = new BrandRepository();

        //when
        Brand foundBrand = brandRepository.findById(3L).orElse(null);

        //then
        Assertions.assertNotNull(foundBrand, "foundToy is empty");

    }
}