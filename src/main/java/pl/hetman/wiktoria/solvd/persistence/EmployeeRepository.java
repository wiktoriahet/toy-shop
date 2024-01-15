package pl.hetman.wiktoria.solvd.persistence;

import org.apache.ibatis.annotations.Param;
import pl.hetman.wiktoria.solvd.model.Employee;
import pl.hetman.wiktoria.solvd.model.Toy;

import java.util.Optional;

public interface EmployeeRepository {
    Optional<Toy> create(Employee employee);

    Optional<Toy> findById(Long id);

    void updateById(@Param("id") Long id, @Param("name") Employee employee);

    void deleteById(Long id);
}
