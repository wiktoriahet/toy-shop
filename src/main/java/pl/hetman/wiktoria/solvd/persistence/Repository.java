package pl.hetman.wiktoria.solvd.persistence;

import java.util.Optional;

public interface Repository<T> {

    Optional<T> create(T t);

    Optional<T> findById(Long id);

    void updateById(Long id, T t);

    void deleteById(Long id);
}
