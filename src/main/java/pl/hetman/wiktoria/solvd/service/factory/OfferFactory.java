package pl.hetman.wiktoria.solvd.service.factory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.hetman.wiktoria.solvd.exceptions.OfferException;
import pl.hetman.wiktoria.solvd.service.impl.DiscountServiceImpl;
import pl.hetman.wiktoria.solvd.service.impl.ToyService;

public class OfferFactory {

    private static final Logger LOGGER = LogManager.getLogger(OfferFactory.class);

    private static final String PRODUCT_DISCOUNT = "PRODUCT DISCOUNT";
    private static final String FREEBIE = "FREEBIE";

    private final DiscountServiceImpl discountService;
    private final ToyService toyService;

    public OfferFactory(DiscountServiceImpl discountService, ToyService toyService) {
        this.discountService = discountService;
        this.toyService = toyService;
    }

    public Offer getOffer(String offerType) throws OfferException {
        LOGGER.info("getOffer(" + offerType + ")");
        switch (offerType) {
            case PRODUCT_DISCOUNT:
                LOGGER.info("getOffer(...)");
                return new ProductDiscount(discountService);
            case FREEBIE:
                LOGGER.info("getOffer(...)");
                return new ProductFreebie(toyService);
            default:
                LOGGER.warn("Can't create an offer. Invalid offerType.");
                throw new OfferException("Can't create an offer. Invalid offerType.");
        }
    }

}
