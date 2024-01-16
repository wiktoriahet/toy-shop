package pl.hetman.wiktoria.solvd.service.factory;

import pl.hetman.wiktoria.solvd.exceptions.OfferException;
import pl.hetman.wiktoria.solvd.service.impl.DiscountServiceImpl;
import pl.hetman.wiktoria.solvd.service.impl.ToyService;

public class OfferFactory {

    private static final String PRODUCT_DISCOUNT = "PRODUCT DISCOUNT";
    private static final String FREEBIE = "FREEBIE";

    private final DiscountServiceImpl discountService;
    private final ToyService toyService;

    public OfferFactory(DiscountServiceImpl discountService, ToyService toyService) {
        this.discountService = discountService;
        this.toyService = toyService;
    }

    public Offer getOffer(String offerType) throws OfferException {
        switch (offerType) {
            case PRODUCT_DISCOUNT:
                return new ProductDiscount(discountService);
            case FREEBIE:
                return new ProductFreebie(toyService);
            default:
                throw new OfferException("Can't create an offer. Invalid offerType.");
        }
    }

}
