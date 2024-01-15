package pl.hetman.wiktoria.solvd.persistence;

import org.apache.ibatis.annotations.Param;
import pl.hetman.wiktoria.solvd.model.Brand;
import pl.hetman.wiktoria.solvd.model.Toy;

import java.util.Optional;

public interface BrandRepository {

    Optional<Toy> create(Toy toy);

    Optional<Toy> findById(Long id);

    void updateById(@Param("id") Long id, @Param("name") Brand brand);

    void deleteById(Long id);

}
