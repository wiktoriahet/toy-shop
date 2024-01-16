package pl.hetman.wiktoria.solvd.persistence.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.hetman.wiktoria.solvd.exceptions.ToyShopException;
import pl.hetman.wiktoria.solvd.model.Discount;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class DiscountRepositoryImplTest {

    @Test
    void validateFindById() throws ToyShopException {
        //given
        DiscountRepositoryImpl discountRepository = new DiscountRepositoryImpl();

        //when
        Optional<Discount> foundedDiscountOptional = discountRepository.findById(1L);
        boolean present = foundedDiscountOptional.isPresent();

        //then
        Assertions.assertTrue(present, "Optional is not present");

    }
}