package pl.hetman.wiktoria.solvd.persistence;

import pl.hetman.wiktoria.solvd.model.Toy;

import java.util.Optional;

public interface Repository<T> {

    Optional<T> create(T t);

    Optional<T> findById(Long id);

    void updateById(Long id, Toy toy);

    void deleteById(Long id);
}
