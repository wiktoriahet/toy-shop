package pl.hetman.wiktoria.solvd.persistence.impl;

import pl.hetman.wiktoria.solvd.model.ToyCategory;
import pl.hetman.wiktoria.solvd.persistence.Repository;

import java.util.Optional;

public class ToyCategoryRepositoryImpl implements Repository<ToyCategory> {
    @Override
    public Optional<ToyCategory> create(ToyCategory toyCategory) {
        return Optional.empty();
    }

    @Override
    public Optional<ToyCategory> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public void updateById(Long id, ToyCategory toyCategory) {

    }

    @Override
    public void deleteById(Long id) {

    }
}
