package pl.hetman.wiktoria.solvd.persistence.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.hetman.wiktoria.solvd.exceptions.ToyShopException;
import pl.hetman.wiktoria.solvd.model.Toy;

import java.util.Optional;

class ToyRepositoryTest {
    static {
        System.setProperty("log4j.configurationFile", "log4j2.xml");
    }

    @Test
    void createToyWithName() {
        //given
        ToyRepository toyRepository = new ToyRepository();
        Toy toy = new Toy();
        toy.setName("Lego Minecraft");

        //when
        Optional<Toy> toyOptional = toyRepository.create(toy);
        Toy toyOptionalUnpacked = toyOptional.orElse(null);

        //then
        Assertions.assertAll(
                () -> Assertions.assertNotNull(toyOptional.isPresent(), "Optional is not present"),
                () -> Assertions.assertNotNull(toyOptionalUnpacked.getName(), "toyOptionalUnpacked.getName() is null")
        );
    }

    @Test
    void createToyWithoutName() {
        //given
        ToyRepository toyRepository = new ToyRepository();
        Toy toy = new Toy();

        //when
        Optional<Toy> toyOptional = toyRepository.create(toy);
        Toy toyOptionalUnpacked = toyOptional.orElse(null);

        //then
        Assertions.assertThrows(
                ToyShopException.class,
                () -> toyRepository.create(toy)
        );
    }

    @Test
    void checkFindById() {
        //given
        ToyRepository toyRepository = new ToyRepository();

        //when
        Toy foundToy = toyRepository.findById(3L).orElse(null);

        //then
        Assertions.assertNotNull(foundToy, "foundToy is empty");

    }

    @Test
    void checkUpdateById(){
        //given
        ToyRepository toyRepository = new ToyRepository();
        Toy beforeUpdateToy = toyRepository.findById(3L).orElse(null);
        String nameBeforeUpdate = beforeUpdateToy.getName();

        Toy toy = new Toy();
        toy.setId(3L);
        toy.setName("Barbie");

        //when
        toyRepository.updateById(3L, toy);
        Optional<Toy> updatedToyOptional = toyRepository.findById(3L);
        Toy updatedToy = updatedToyOptional.orElse(null);

        //then
        Assertions.assertEquals(toy.getName(), updatedToy.getName());

    }

    @Test
    void checkDeleteById(){
        //given
        ToyRepository toyRepository = new ToyRepository();
        Toy beforeDeleteToy = toyRepository.findById(3L).orElse(null);

        //when
        toyRepository.deleteById(3L);
        Toy afterDeleteToy = toyRepository.findById(3L).orElse(null);

        //then
        Assertions.assertNull(afterDeleteToy, "afterDeleteToy is not null");

    }
}
