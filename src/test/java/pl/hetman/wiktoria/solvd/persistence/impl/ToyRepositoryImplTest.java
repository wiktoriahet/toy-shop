package pl.hetman.wiktoria.solvd.persistence.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.hetman.wiktoria.solvd.model.Toy;

import java.util.Optional;

class ToyRepositoryImplTest {
    static {
        System.setProperty("log4j.configurationFile", "log4j2.xml");
    }

    @Test
    void createToyWithName() {
        //given
        ToyRepositoryImpl toyRepositoryImpl = new ToyRepositoryImpl();
        Toy toy = new Toy();
        toy.setName("Lego Minecraft");

        //when
        Optional<Toy> toyOptional = toyRepositoryImpl.create(toy);
        Toy toyOptionalUnpacked = toyOptional.orElse(null);

        //then
        Assertions.assertAll(
                () -> Assertions.assertTrue(toyOptional.isPresent(), "Optional is not present"),
                () -> Assertions.assertNotNull(toyOptionalUnpacked.getName(), "toyOptionalUnpacked.getName() is null")
        );
    }

    @Test
    void createToyWithoutName() {
        //given
        ToyRepositoryImpl toyRepositoryImpl = new ToyRepositoryImpl();
        Toy toy = new Toy();

        //when

        //then
        Assertions.assertThrows(
                RuntimeException.class,
                () -> toyRepositoryImpl.create(toy)
        );
    }

    @Test
    void checkFindById() {
        //given
        ToyRepositoryImpl toyRepositoryImpl = new ToyRepositoryImpl();

        //when
        Toy foundToy = toyRepositoryImpl.findById(10L).orElse(null);

        //then
        Assertions.assertNotNull(foundToy, "foundToy is empty");

    }

    @Test
    void checkUpdateById(){
        //given
        ToyRepositoryImpl toyRepositoryImpl = new ToyRepositoryImpl();
        Toy beforeUpdateToy = toyRepositoryImpl.findById(10L).orElse(null);
        String nameBeforeUpdate = beforeUpdateToy.getName();

        Toy toy = new Toy();
        toy.setId(10L);
        toy.setName("Barbie");

        //when
        toyRepositoryImpl.updateById(10L, toy);
        Optional<Toy> updatedToyOptional = toyRepositoryImpl.findById(10L);
        Toy updatedToy = updatedToyOptional.orElse(null);

        //then
        Assertions.assertEquals(toy.getName(), updatedToy.getName());

    }

    @Test
    void checkDeleteById(){
        //given
        ToyRepositoryImpl toyRepositoryImpl = new ToyRepositoryImpl();
        Toy beforeDeleteToy = toyRepositoryImpl.findById(4L).orElse(null);

        //when
        toyRepositoryImpl.deleteById(4L);
        Toy afterDeleteToy = toyRepositoryImpl.findById(4L).orElse(null);

        //then
        Assertions.assertNull(afterDeleteToy, "afterDeleteToy is not null");

    }

    @Test
    void createAlreadyExist() {
        //given
        ToyRepositoryImpl toyRepositoryImpl = new ToyRepositoryImpl();
        Toy toy = new Toy();
        toy.setId(1L);
        toy.setName("Lego Minecraft");

        //when

        //then
        Assertions.assertThrows(
                RuntimeException.class,
                () -> toyRepositoryImpl.create(toy)
        );
    }
}
