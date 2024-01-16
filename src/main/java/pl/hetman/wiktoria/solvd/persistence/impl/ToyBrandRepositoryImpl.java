package pl.hetman.wiktoria.solvd.persistence.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.hetman.wiktoria.solvd.model.Brand;
import pl.hetman.wiktoria.solvd.model.Toy;
import pl.hetman.wiktoria.solvd.model.ToyBrand;
import pl.hetman.wiktoria.solvd.persistence.ToyBrandRepository;

import java.util.Optional;

public class ToyBrandRepositoryImpl implements ToyBrandRepository {

    private static final Logger LOGGER = LogManager.getLogger(ToyBrandRepositoryImpl.class);

    @Override
    public Integer create(Toy toy, Brand brand) {
        LOGGER.info("create(" + toy + ", " + brand + ")");
        /**
         * Creates a toy brand
         *
         * TODO: Implement this method.
         *
         */
        LOGGER.info("create(...)");
        return null;
    }

    @Override
    public Optional<ToyBrand> findById(Long id) {
        LOGGER.info("findById(" + id + ")");
        /**
         * Finds toy brand by id
         *
         * TODO: Implement this method.
         *
         */
        LOGGER.info("findById(...)");
        return Optional.empty();
    }

    @Override
    public void updateToyById(Long id, Toy toy) {
        LOGGER.info("updateToyById(" + id + ", " + toy + ")");
        /**
         * Updates toy in toy brand
         *
         * TODO: Implement this method.
         *
         */
        LOGGER.info("updateToyById(...)");
    }

    @Override
    public void updateBrandById(Long id, Brand brand) {
        LOGGER.info("updateBrandById(" + id + ", " + brand + ")");
        /**
         * Updates brand in toy brand
         *
         * TODO: Implement this method.
         *
         */
        LOGGER.info("updateBrandById(...)");
    }

    @Override
    public void deleteById(Long id) {
        LOGGER.info("deleteById(" + id + ")");
        /**
         * Delete a toy brand by id
         *
         * TODO: Implement this method.
         *
         */
        LOGGER.info("deleteById(...)");
    }
}
