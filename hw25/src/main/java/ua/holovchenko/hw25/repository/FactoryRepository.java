package ua.holovchenko.hw25.repository;

import ua.holovchenko.hw25.entity.Factory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FactoryRepository extends AbstractRepository<Factory, Integer> {

    public void createTable() throws SQLException {
        String createTableSQL = """
                 CREATE TABLE IF NOT EXISTS Factory (
                                         id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                                         name VARCHAR(255),
                                         country VARCHAR(255)
                );""";
        try (Connection connection = createConnection();
        PreparedStatement statement = connection.prepareStatement(createTableSQL)){
            statement.execute();
        }
    }

    @Override
    public Optional<Factory> getByID(Integer id) throws SQLException {
        try (Connection connection = createConnection();
             PreparedStatement statement = connection.prepareStatement("select * from factory where id = ?")) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return Optional.of(extractEntityFromResultSet(resultSet));
                }
                return Optional.empty();
            }
        }
    }

    @Override
    public List<Factory> getAll() throws SQLException {
        List<Factory> factories = new ArrayList<>();
        try (Connection connection = createConnection();
             PreparedStatement statement = connection.prepareStatement("select * from factory")) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    factories.add(extractEntityFromResultSet(resultSet));
                }
            }
        }
        return factories;

    }

    @Override
    public boolean add(Factory factory) throws SQLException {
        try (Connection connection = createConnection();
             PreparedStatement statement = connection.prepareStatement
                     ("INSERT INTO factory " +
                             "(name, country) " +
                             "VALUES (?,?)")) {
            statement.setString(1, factory.getName());
            statement.setString(2, factory.getCountry());
            return statement.execute();
        }
    }

    @Override
    public void remove(Integer id) throws SQLException {
        try (Connection connection = createConnection();
             PreparedStatement statement = connection.prepareStatement("delete from factory where id = ?")) {
            statement.setInt(1, id);
            statement.execute();
        }
    }

    public void setFactoriesSummary() throws SQLException {
        try (Connection connection = createConnection();
        PreparedStatement statement = connection.prepareStatement(
                "SELECT factoryId, factory.name, factory.country," +
                        " COUNT(device.id) as devices_amount, SUM(device.price) as devices_pricesum " +
                        "FROM device JOIN factory on factory.id = device.factoryId " +
                        "GROUP BY factoryId, factory.name, factory.country"
                        )){
            try (ResultSet resultSet = statement.executeQuery()){
                while (resultSet.next()) {
                    System.out.println(
                                    resultSet.getInt(1) + " " + resultSet.getString(2)
                                    + " " + resultSet.getString(3) + " " + resultSet.getInt(4)
                                    + " " + resultSet.getBigDecimal(5));
                }
            }
        }
    }

    private static Factory extractEntityFromResultSet(ResultSet resultSet) throws SQLException {
        Factory factory = new Factory();
        factory.setId(resultSet.getInt("id"));
        factory.setName(resultSet.getString("name"));
        factory.setCountry(resultSet.getString("country"));
        return factory;
    }


}
