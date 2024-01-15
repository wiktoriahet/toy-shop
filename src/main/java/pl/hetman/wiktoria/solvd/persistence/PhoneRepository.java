package pl.hetman.wiktoria.solvd.persistence;

import org.apache.ibatis.annotations.Param;
import pl.hetman.wiktoria.solvd.model.Phone;
import pl.hetman.wiktoria.solvd.model.Toy;

import java.util.Optional;

public interface PhoneRepository {

    Optional<Toy> create(Phone phone);

    Optional<Toy> findById(Long id);

    void updateById(@Param("id") Long id, @Param("phone")Phone phone);

    void deleteById(Long id);
}
