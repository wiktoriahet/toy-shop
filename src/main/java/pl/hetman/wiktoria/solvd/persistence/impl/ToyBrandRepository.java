package pl.hetman.wiktoria.solvd.persistence.impl;

import pl.hetman.wiktoria.solvd.model.Toy;
import pl.hetman.wiktoria.solvd.model.ToyBrand;
import pl.hetman.wiktoria.solvd.persistence.Repository;

import java.util.Optional;

public class ToyBrandRepository implements Repository<ToyBrand> {
    @Override
    public Optional<ToyBrand> create(ToyBrand toyBrand) {
        return Optional.empty();
    }

    @Override
    public Optional<ToyBrand> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public void updateById(Long id, Toy toy) {

    }

    @Override
    public void deleteById(Long id) {

    }
}
