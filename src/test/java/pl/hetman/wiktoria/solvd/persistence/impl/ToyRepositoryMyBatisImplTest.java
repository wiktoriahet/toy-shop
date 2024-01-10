package pl.hetman.wiktoria.solvd.persistence.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.hetman.wiktoria.solvd.exceptions.ToyShopException;
import pl.hetman.wiktoria.solvd.model.Toy;

public class ToyRepositoryMyBatisImplTest {

    static {
        System.setProperty("log4j.configurationFile", "log4j2.xml");
    }

    @Test
    void validateCreateToyWithValidData() throws ToyShopException {

        //given
        ToyRepositoryMyBatisImpl toyRepositoryImpl = new ToyRepositoryMyBatisImpl();
        Toy toy = new Toy();
        toy.setName("Lego Minecraft");

        //when
        Integer createdToy = toyRepositoryImpl.create(toy);

        //then
        Assertions.assertNotNull(createdToy, "createdToy is null");
    }

    @Test
    void validateCreateToyWithoutName() {
        //given
        ToyRepositoryMyBatisImpl toyRepositoryImpl = new ToyRepositoryMyBatisImpl();
        Toy toy = new Toy();

        //when

        //then
        Assertions.assertThrows(
                ToyShopException.class,
                () -> toyRepositoryImpl.create(toy)
        );
    }
}
