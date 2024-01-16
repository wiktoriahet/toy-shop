package pl.hetman.wiktoria.solvd.persistence.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.hetman.wiktoria.solvd.model.ToyCategory;
import pl.hetman.wiktoria.solvd.persistence.Repository;

import java.util.Optional;

public class ToyCategoryRepositoryImpl implements Repository<ToyCategory> {

    private static final Logger LOGGER = LogManager.getLogger(ToyCategoryRepositoryImpl.class);

    @Override
    public Optional<ToyCategory> create(ToyCategory toyCategory) {
        LOGGER.info("create(" + toyCategory + ")");
        /**
         * Creates a toy category
         *
         * TODO: Implement this method.
         *
         */
        LOGGER.info("create(...)");
        return Optional.empty();
    }

    @Override
    public Optional<ToyCategory> findById(Long id) {
        LOGGER.info("findById(" + id + ")");
        /**
         * Finds toy category by id
         *
         * TODO: Implement this method.
         *
         */
        LOGGER.info("findById(...)");
        return Optional.empty();
    }

    @Override
    public void updateById(Long id, ToyCategory toyCategory) {
        LOGGER.info("updateById(" + id + ", " + toyCategory + ")");
        /**
         * Updates toy category by id
         *
         * TODO: Implement this method.
         *
         */
        LOGGER.info("updateById(...)");
    }

    @Override
    public void deleteById(Long id) {
        LOGGER.info("deleteById(" + id + ")");
        /**
         * Delete a toy category by id
         *
         * TODO: Implement this method.
         *
         */
        LOGGER.info("deleteById(...)");
    }
}
