package pl.hetman.wiktoria.solvd.service.facade;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.hetman.wiktoria.solvd.exceptions.OfferException;
import pl.hetman.wiktoria.solvd.persistence.impl.DiscountRepositoryImpl;
import pl.hetman.wiktoria.solvd.persistence.impl.ToyRepositoryMyBatisImpl;
import pl.hetman.wiktoria.solvd.service.factory.Offer;
import pl.hetman.wiktoria.solvd.service.factory.OfferFactory;
import pl.hetman.wiktoria.solvd.service.impl.DiscountServiceImpl;
import pl.hetman.wiktoria.solvd.service.impl.ToyService;

public class ToyShopPromotionFacade {

    private static final Logger LOGGER = LogManager.getLogger(ToyShopPromotionFacade.class);

    Offer choosePromotion(String option) throws OfferException {
        LOGGER.info("choosePromotion(" + option + ")");
        DiscountRepositoryImpl discountRepository = new DiscountRepositoryImpl();
        DiscountServiceImpl discountService = new DiscountServiceImpl(discountRepository);
        ToyRepositoryMyBatisImpl toyRepositoryMyBatis = new ToyRepositoryMyBatisImpl();
        ToyService toyService = new ToyService(toyRepositoryMyBatis);
        OfferFactory offerFactory = new OfferFactory(discountService, toyService);
        Offer offer = offerFactory.getOffer(option);
        LOGGER.info("choosePromotion(...)");
        return offer;
    }

}
