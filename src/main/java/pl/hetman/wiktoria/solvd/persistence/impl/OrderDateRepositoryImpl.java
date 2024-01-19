package pl.hetman.wiktoria.solvd.persistence.impl;

import org.apache.ibatis.session.SqlSession;
import pl.hetman.wiktoria.solvd.exceptions.ToyShopException;
import pl.hetman.wiktoria.solvd.model.OrderDate;
import pl.hetman.wiktoria.solvd.persistence.OrderDateRepository;
import pl.hetman.wiktoria.solvd.persistence.PersistenceConfig;

import java.util.Optional;

public class OrderDateRepositoryImpl implements OrderDateRepository {
    @Override
    public Optional<OrderDate> findById(Long id) throws ToyShopException {
        if (id != null) {
            try (SqlSession sessionFactory =
                         PersistenceConfig
                                 .getSessionFactory()
                                 .openSession(true);) {
                OrderDateRepository orderDateRepository = sessionFactory.getMapper(OrderDateRepository.class);
                Optional<OrderDate> foundedOrderDate = orderDateRepository.findById(id);
                return foundedOrderDate;
            } catch (RuntimeException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
