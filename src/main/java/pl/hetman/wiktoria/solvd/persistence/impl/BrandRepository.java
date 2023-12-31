package pl.hetman.wiktoria.solvd.persistence.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.hetman.wiktoria.solvd.exceptions.ToyShopException;
import pl.hetman.wiktoria.solvd.model.Brand;
import pl.hetman.wiktoria.solvd.persistence.ConnectionPool;
import pl.hetman.wiktoria.solvd.persistence.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class BrandRepository implements Repository<Brand> {

    private static final Logger LOGGER = LogManager.getLogger(BrandRepository.class);

    private static final String CREATE_BRAND_QUERY = "INSERT INTO toy_shop_fixed.brands (name) VALUES(?)";
    private static final String FIND_BRAND_BY_ID_QUERY = "SELECT * FROM toy_shop_fixed.brands WHERE id = ?";
    private static final String UPDATE_BRAND_BY_ID_QUERY = "UPDATE toy_shop_fixed.brands SET name = ? WHERE id = ?";
    private static final String DELETE_BRAND_BY_ID_QUERY = "DELETE FROM toy_shop_fixed.brands WHERE id = ?";

    @Override
    public Optional<Brand> create(Brand brand) {
        LOGGER.info("create(" + brand + ")");

        try (Connection connection = ConnectionPool.getInstance().take().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(CREATE_BRAND_QUERY);
        ) {

            if (brand == null) {
                LOGGER.warn("ToyShopException");
                throw new ToyShopException("Can't create a brand. Object is empty.");
            } else if (brand.getName().equals(null)) {
                LOGGER.warn("ToyShopException");
                throw new ToyShopException("Can't create a brand. Toy's name is null.");
            } else {
                preparedStatement.setString(1, brand.getName());
                preparedStatement.executeUpdate();
                LOGGER.info("Successfully created a brand " + brand);
            }

        } catch (ToyShopException | InterruptedException | SQLException e) {
            LOGGER.warn("ToyShopException: " + e.getMessage());
            throw new RuntimeException(e);
        }

        Optional<Brand> brandOptional = Optional.of(brand);

        LOGGER.info("create(...) = " + brandOptional);
        return brandOptional;
    }

    @Override
    public Optional<Brand> findById(Long id) {
        LOGGER.info("findById(" + id + ")");

        try (Connection connection = ConnectionPool.getInstance().take().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_BRAND_BY_ID_QUERY);) {

            if (id == null) {
                LOGGER.warn("ToyShopException");
                throw new ToyShopException("Can't find a brand. Id is null.");
            } else {
                preparedStatement.setLong(1, id);
                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    Brand brand = new Brand();
                    brand.setName(resultSet.getString("name"));
                    brand.setId(id);
                    LOGGER.info("Successfully found brand with id " + id);
                    return Optional.of(brand);
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
    public void updateById(Long id, Brand brand) {
        LOGGER.info("updateById(" + id + ")");

        try (Connection connection = ConnectionPool.getInstance().take().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_BRAND_BY_ID_QUERY);) {

            if (id == null) {
                LOGGER.warn("ToyShopException");
                throw new ToyShopException("Can't update a brand. Id is null.");
            } else if (brand == null) {
                LOGGER.warn("ToyShopException");
                throw new ToyShopException("Can't update a brand. Brand is null.");
            } else {
                preparedStatement.setLong(2, id);
                preparedStatement.setString(1, brand.getName());

                preparedStatement.executeUpdate();

                LOGGER.info("Successfully updated brand with id " + id);

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
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BRAND_BY_ID_QUERY);) {

            if (id == null) {
                LOGGER.warn("ToyShopException");
                throw new ToyShopException("Can't delete a brand. Id is null.");
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
