package pl.hetman.wiktoria.solvd.service.facade;

import pl.hetman.wiktoria.solvd.exceptions.OfferException;
import pl.hetman.wiktoria.solvd.persistence.impl.DiscountRepositoryImpl;
import pl.hetman.wiktoria.solvd.persistence.impl.ToyRepositoryMyBatisImpl;
import pl.hetman.wiktoria.solvd.service.factory.Offer;
import pl.hetman.wiktoria.solvd.service.factory.OfferFactory;
import pl.hetman.wiktoria.solvd.service.impl.DiscountServiceImpl;
import pl.hetman.wiktoria.solvd.service.impl.ToyService;

public class ToyShopPromotionFacade {

    Offer choosePromotion(String option) throws OfferException {
        DiscountRepositoryImpl discountRepository = new DiscountRepositoryImpl();
        DiscountServiceImpl discountService = new DiscountServiceImpl(discountRepository);
        ToyRepositoryMyBatisImpl toyRepositoryMyBatis = new ToyRepositoryMyBatisImpl();
        ToyService toyService = new ToyService(toyRepositoryMyBatis);
        OfferFactory offerFactory = new OfferFactory(discountService, toyService);
        Offer offer = offerFactory.getOffer(option);
        return offer;
    }

}
