package pl.hetman.wiktoria.solvd.persistence.impl;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.hetman.wiktoria.solvd.model.Email;
import pl.hetman.wiktoria.solvd.model.Employee;
import pl.hetman.wiktoria.solvd.model.EmployeeContactEmail;
import pl.hetman.wiktoria.solvd.persistence.EmployeeEmailRepository;
import pl.hetman.wiktoria.solvd.persistence.PersistenceConfig;

import java.util.Optional;

public class EmployeeEmailMyBatisImpl implements EmployeeEmailRepository {

    private static final Logger LOGGER = LogManager.getLogger(EmployeeEmailMyBatisImpl.class);

    @Override
    public Optional<EmployeeContactEmail> addEmail(Employee employee, Email email) {
        return Optional.empty();
    }

    @Override
    public Optional<EmployeeContactEmail> findById(Long id) {

        try (SqlSession sessionFactory =
                     PersistenceConfig
                             .getSessionFactory()
                             .openSession(true);) {


            EmployeeEmailRepository employeeEmailRepository =
                    sessionFactory.getMapper(EmployeeEmailRepository.class);

            LOGGER.debug("Executing SQL Query: SELECT * FROM toy_shop_fixed.employees_contacts_emails ece JOIN toy_shop_fixed.emails e ON ece.email_id = e.id WHERE ece.id = {}", id);


            EmployeeContactEmail employeeContactEmail = employeeEmailRepository.findById(10L).orElseThrow(
                    () -> new RuntimeException("Can't find EmployeeContact in db")
            );

            return Optional.of(employeeContactEmail);

        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        return Optional.empty();

    }

    @Override
    public void deleteById(Long id) {

    }
}
