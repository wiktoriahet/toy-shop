package pl.hetman.wiktoria.solvd.service.factory;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.hetman.wiktoria.solvd.exceptions.OfferException;
import pl.hetman.wiktoria.solvd.exceptions.ToyShopException;
import pl.hetman.wiktoria.solvd.model.Discount;
import pl.hetman.wiktoria.solvd.model.Toy;
import pl.hetman.wiktoria.solvd.persistence.impl.DiscountRepositoryImpl;
import pl.hetman.wiktoria.solvd.persistence.impl.ToyRepositoryMyBatisImpl;
import pl.hetman.wiktoria.solvd.service.impl.DiscountServiceImpl;
import pl.hetman.wiktoria.solvd.service.impl.ToyService;

import java.util.Optional;

class OfferFactoryTest {

    private static final String PRODUCT_DISCOUNT = "PRODUCT DISCOUNT";
    private static final String FREEBIE = "FREEBIE";

    @Test
    void validateGetOffer() throws OfferException, ToyShopException {
        //given
        DiscountRepositoryImpl discountRepository = new DiscountRepositoryImpl();
        DiscountServiceImpl discountService = new DiscountServiceImpl(discountRepository);
        ToyRepositoryMyBatisImpl toyRepositoryMyBatis = new ToyRepositoryMyBatisImpl();
        ToyService toyService = new ToyService(toyRepositoryMyBatis);
        OfferFactory offerFactory = new OfferFactory(discountService, toyService);

        //when
        Offer discount = offerFactory.getOffer(PRODUCT_DISCOUNT);
        Offer freebie = offerFactory.getOffer(FREEBIE);
        Optional<Discount> optionalDiscount = discount.makeOffer(1L);
        Optional<Toy> optionalFreebie = freebie.makeOffer(1L);
        boolean isDiscountPresent = optionalDiscount.isPresent();
        boolean isFreebiePresent = optionalFreebie.isPresent();

        //then
        Assertions.assertAll(
                () -> Assertions.assertNotNull(discount, "Discount is null"),
                () -> Assertions.assertNotNull(freebie, "Freebie is null"),
                () -> Assertions.assertTrue(isDiscountPresent, "Discount is not present"),
                () -> Assertions.assertTrue(isFreebiePresent, "Freebie is not present")
        );

    }
}