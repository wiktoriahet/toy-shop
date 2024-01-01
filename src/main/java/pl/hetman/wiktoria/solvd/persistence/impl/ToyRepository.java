package pl.hetman.wiktoria.solvd.persistence.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.hetman.wiktoria.solvd.exceptions.ToyShopException;
import pl.hetman.wiktoria.solvd.model.Toy;
import pl.hetman.wiktoria.solvd.persistence.ConnectionPool;
import pl.hetman.wiktoria.solvd.persistence.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class ToyRepository implements Repository<Toy> {

    private static final Logger LOGGER = LogManager.getLogger(ToyRepository.class);

    private static final String CREATE_TOY_QUERY = "INSERT INTO toy_shop_fixed.toys (name) VALUES(?)";
    private static final String FIND_TOY_BY_ID_QUERY = "SELECT * FROM toy_shop_fixed.toys WHERE id = ?";
    private static final String UPDATE_TOY_BY_ID_QUERY = "UPDATE toy_shop_fixed.toys SET name = ? WHERE id = ?";
    private static final String DELETE_TOY_BY_ID_QUERY = "DELETE FROM toy_shop_fixed.toys WHERE id = ?";

    @Override
    public Optional<Toy> create(Toy toy) {
        LOGGER.info("create(" + toy + ")");

        try (Connection connection = ConnectionPool.getInstance().take().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(CREATE_TOY_QUERY);
        ) {
            if(toy.getId()!=null){
                Toy foundedToy = findById(toy.getId()).orElse(null);
                if(foundedToy != null){
                    throw new ToyShopException("Can't create a toy. Toy already exists.");
                }
            } else if (toy == null) {
                LOGGER.warn("ToyShopException");
                throw new ToyShopException("Can't create a toy. Object is empty.");
            } else if (toy.getName().equals(null)) {
                LOGGER.warn("ToyShopException");
                throw new ToyShopException("Can't create a toy. Toy's name is null.");
            } else {
                preparedStatement.setString(1, toy.getName());
                preparedStatement.executeUpdate();
                LOGGER.info("Successfully created a toy " + toy);
            }

        } catch (ToyShopException | InterruptedException | SQLException e) {
            LOGGER.warn("ToyShopException: " + e.getMessage());
            throw new RuntimeException(e);
        }

        Optional<Toy> toyOptional = Optional.of(toy);

        LOGGER.info("create(...) = " + toyOptional);
        return toyOptional;
    }

    @Override
    public Optional<Toy> findById(Long id) {
        LOGGER.info("findById(" + id + ")");

        try (Connection connection = ConnectionPool.getInstance().take().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_TOY_BY_ID_QUERY);) {

            if (id == null) {
                LOGGER.warn("ToyShopException");
                throw new ToyShopException("Can't find toy. Id is null.");
            } else {
                preparedStatement.setLong(1, id);
                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    Toy toy = new Toy();
                    toy.setName(resultSet.getString("name"));
                    toy.setId(id);
                    LOGGER.info("Successfully found toy with id " + id);
                    return Optional.of(toy);
                }
            }

        } catch (ToyShopException | InterruptedException | SQLException e) {
            LOGGER.warn("ToyShopException: " + e.getMessage());
            throw new RuntimeException(e);
        }

        LOGGER.info("findById(...)");
        return Optional.empty();
    }

    @Override
    public void updateById(Long id, Toy toy) {
        LOGGER.info("updateById(" + id + ")");

        try (Connection connection = ConnectionPool.getInstance().take().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_TOY_BY_ID_QUERY);) {

            if (id == null) {
                LOGGER.warn("ToyShopException");
                throw new ToyShopException("Can't update toy. Id is null.");
            } else if (toy == null) {
                LOGGER.warn("ToyShopException");
                throw new ToyShopException("Can't update toy. Toy is null.");
            } else {
                preparedStatement.setLong(2, id);
                preparedStatement.setString(1, toy.getName());

                preparedStatement.executeUpdate();

                LOGGER.info("Successfully updated toy with id " + id);

            }

        } catch (ToyShopException | InterruptedException | SQLException e) {
            LOGGER.warn("ToyShopException: " + e.getMessage());
            throw new RuntimeException(e);
        }

        LOGGER.info("updateById(...)");
    }

    @Override
    public void deleteById(Long id) {

        LOGGER.info("deleteById(" + id + ")");

        try (Connection connection = ConnectionPool.getInstance().take().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_TOY_BY_ID_QUERY);) {

            if (id == null) {
                LOGGER.warn("ToyShopException");
                throw new ToyShopException("Can't delete toy. Id is null.");
            } else {
                preparedStatement.setLong(1, id);
                preparedStatement.executeUpdate();
            }

        } catch (ToyShopException | SQLException | InterruptedException e) {
            LOGGER.warn("ToyShopException: " + e.getMessage());
            throw new RuntimeException(e);
        }

        LOGGER.info("deleteById(...)");
    }
}
