package pl.hetman.wiktoria.solvd.service.facade;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.hetman.wiktoria.solvd.exceptions.OfferException;
import pl.hetman.wiktoria.solvd.service.factory.Offer;

import static org.junit.jupiter.api.Assertions.*;

class ToyShopPromotionFacadeTest {

    private static final String PRODUCT_DISCOUNT = "PRODUCT DISCOUNT";
    private static final String FREEBIE = "FREEBIE";

    @Test
    void validateChoosePromotion() throws OfferException {
        //given
        ToyShopPromotionFacade toyShopPromotionFacade = new ToyShopPromotionFacade();

        //when
        Offer offer = toyShopPromotionFacade.choosePromotion(FREEBIE);

        //then
        Assertions.assertNotNull(offer, "offer is null");

    }
}