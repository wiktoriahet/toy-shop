package pl.hetman.wiktoria.solvd.persistence.impl;

import org.apache.ibatis.session.SqlSession;
import pl.hetman.wiktoria.solvd.exceptions.ToyShopException;
import pl.hetman.wiktoria.solvd.model.OrderPrice;
import pl.hetman.wiktoria.solvd.persistence.OrderPriceRepository;
import pl.hetman.wiktoria.solvd.persistence.PersistenceConfig;

import java.util.Optional;

public class OrderPriceRepositoryImpl implements OrderPriceRepository {

    @Override
    public Optional<OrderPrice> findById(Long id) throws ToyShopException {
        if (id != null) {
            try (SqlSession sessionFactory =
                         PersistenceConfig
                                 .getSessionFactory()
                                 .openSession(true);) {
                OrderPriceRepository orderDateRepository = sessionFactory.getMapper(OrderPriceRepository.class);
                Optional<OrderPrice> foundedOrderPrice = orderDateRepository.findById(id);
                return foundedOrderPrice;
            } catch (RuntimeException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
