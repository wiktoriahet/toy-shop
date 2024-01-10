package pl.hetman.wiktoria.solvd.persistence.impl;

import pl.hetman.wiktoria.solvd.model.Brand;
import pl.hetman.wiktoria.solvd.model.Toy;
import pl.hetman.wiktoria.solvd.model.ToyBrand;
import pl.hetman.wiktoria.solvd.persistence.ToyBrandRepository;

import java.util.Optional;

public class ToyBrandRepositoryImpl implements ToyBrandRepository {

    @Override
    public Integer create(Toy toy, Brand brand) {
        return null;
    }

    @Override
    public Optional<ToyBrand> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public void updateToyById(Long id, Toy toy) {

    }

    @Override
    public void updateBrandById(Long id, Brand brand) {

    }

    @Override
    public void deleteById(Long id) {

    }
}
