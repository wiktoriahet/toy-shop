package pl.hetman.wiktoria.solvd.service.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.hetman.wiktoria.solvd.exceptions.ToyShopException;
import pl.hetman.wiktoria.solvd.model.Toy;
import pl.hetman.wiktoria.solvd.persistence.impl.ToyRepositoryMyBatisImpl;

import java.util.Optional;

class ToyServiceTest {

    @Test
    void validateCreateWithValidData() throws ToyShopException {
        //given
        ToyRepositoryMyBatisImpl toyRepositoryImpl = new ToyRepositoryMyBatisImpl();
        ToyService toyService = new ToyService(toyRepositoryImpl);
        Toy toy = new Toy();
        toy.setName("Jump rope");

        //when
        Optional<Toy> createdToyOptional = toyService.create(toy);
        Toy createdToy = createdToyOptional.orElse(null);
        System.out.println(createdToy);

        //then
        Assertions.assertNotNull(createdToy, "createdToy is null");

    }

    @Test
    void validateCreateWithoutName() throws ToyShopException {
        //given
        ToyRepositoryMyBatisImpl toyRepositoryImpl = new ToyRepositoryMyBatisImpl();
        ToyService toyService = new ToyService(toyRepositoryImpl);
        Toy toy = new Toy();

        //when

        //then
        Assertions.assertThrows(
                ToyShopException.class,
                () -> toyService.create(toy)
        );
    }

    @Test
    void validateFindByIdWithValidData() throws ToyShopException{
        //given
        ToyRepositoryMyBatisImpl toyRepositoryImpl = new ToyRepositoryMyBatisImpl();
        ToyService toyService = new ToyService(toyRepositoryImpl);

        //when
        Toy foundToy = toyService.findById(1L).orElse(null);

        //then
        Assertions.assertNotNull(foundToy, "foundToy is empty");
    }

    @Test
    void validateUpdateByIdWithValidData() throws ToyShopException{
        //given
        ToyRepositoryMyBatisImpl toyRepositoryImpl = new ToyRepositoryMyBatisImpl();
        ToyService toyService = new ToyService(toyRepositoryImpl);
        Toy beforeUpdateToy = toyService.findById(1L).orElse(null);
        String nameBeforeUpdate = beforeUpdateToy.getName();

        Toy toy = new Toy();
        toy.setId(10L);
        toy.setName("Barbie");

        //when
        toyService.updateById(10L, toy);
        Optional<Toy> updatedToyOptional = toyService.findById(10L);
        Toy updatedToy = updatedToyOptional.orElse(null);

        //then
        Assertions.assertEquals(toy.getName(), updatedToy.getName());
    }

    @Test
    void validateDeleteByIdWithValidData() throws ToyShopException{
        //given
        ToyRepositoryMyBatisImpl toyRepositoryImpl = new ToyRepositoryMyBatisImpl();
        ToyService toyService = new ToyService(toyRepositoryImpl);
        Toy beforeDeleteToy = toyService.findById(19L).orElse(null);

        //when
        toyService.deleteById(19L);

        //then
        Assertions.assertNotNull(beforeDeleteToy, "beforeDeleteToy is null");
        Assertions.assertThrows(
                ToyShopException.class,
                () -> toyService.findById(19L)
        );

    }
}