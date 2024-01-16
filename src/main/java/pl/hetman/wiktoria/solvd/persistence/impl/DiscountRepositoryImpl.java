package pl.hetman.wiktoria.solvd.persistence.impl;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.hetman.wiktoria.solvd.exceptions.ToyShopException;
import pl.hetman.wiktoria.solvd.model.Discount;
import pl.hetman.wiktoria.solvd.persistence.DiscountRepository;
import pl.hetman.wiktoria.solvd.persistence.PersistenceConfig;

import java.util.Optional;

public class DiscountRepositoryImpl implements DiscountRepository {

    private static final Logger LOGGER = LogManager.getLogger(DiscountRepositoryImpl.class);

    @Override
    public Optional<Discount> findById(Long id) throws ToyShopException {
        LOGGER.info("findById(" + id + ")");
        if (id != null) {
            try (SqlSession sessionFactory =
                         PersistenceConfig
                                 .getSessionFactory()
                                 .openSession(true);) {
                DiscountRepository discountRepository = sessionFactory.getMapper(DiscountRepository.class);
                Discount foundDiscount = discountRepository.findById(id).orElseThrow(
                        () -> new ToyShopException("Can't find discount.")
                );
                LOGGER.info("findById(" + foundDiscount + ")");
                return Optional.of(foundDiscount);
            } catch (RuntimeException e) {
                LOGGER.warn(e.getMessage());
                e.printStackTrace();
            }
        }
        LOGGER.info("findById(...)");
        return Optional.empty();
    }
}
