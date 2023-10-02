package shop.repository.jdbc;

import lombok.SneakyThrows;
import shop.entity.Client;
import shop.repository.ClientRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientRepositoryImpl extends AbstractJDBCRepository implements ClientRepository {
    private static final String CREATE_USER_SQL = "INSERT INTO clients (client_id, first_name, last_name, date_of_birth) VALUES (?,?,?,?)";
    private static final String SELECT_ALL_CLIENTS_SQL = "SELECT * FROM clients";
    private static final String SELECT_CLIENT_BY_ID_SQL = "SELECT * FROM clients WHERE client_id = ?";

    @SneakyThrows
    @Override
    public Client getById(String id) {
        try (Connection connection = createConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_CLIENT_BY_ID_SQL)) {
            statement.setString(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return extractClientFromResultSet(resultSet);
                }
                return null;
            }
        }
    }

    @SneakyThrows
    @Override
    public List<Client> getAll() {
        List<Client> clients = new ArrayList<>();
        try (Connection connection = createConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SELECT_ALL_CLIENTS_SQL)) {
            while (resultSet.next()) {
                clients.add(extractClientFromResultSet(resultSet));
            }
            return clients;
        }
    }

    @SneakyThrows
    @Override
    public void save(Client client) {
        try (Connection connection = createConnection();
             PreparedStatement statement = connection.prepareStatement(CREATE_USER_SQL)) {
            statement.setString(1, client.getId());
            statement.setString(2, client.getFirstName());
            statement.setString(3, client.getLastName());
            statement.setDate(4, Date.valueOf(client.getDateOfBirth()));
            statement.execute();
        }
    }

    @SneakyThrows
    @Override
    public List<Client> getClientsWithAmountOfOrdersGreater(int amount) {
        ArrayList<Client> clients = new ArrayList<>();
        try(Connection connection = createConnection();
        PreparedStatement statement = connection.prepareStatement(
                "SELECT * FROM clients JOIN (" +
                        "SELECT COUNT(*) AS count, client_id FROM orders GROUP BY client_id HAVING count > ?) AS orders_count " +
                        "ON clients.client_id = orders_count.client_id")) {
            statement.setInt(1, amount);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                clients.add(extractClientFromResultSet(resultSet));
            }
        }
        return clients;
    }

    @SneakyThrows
    @Override
    public int removeAllClientsYoungerThan(int age) {
        try (Connection connection = createConnection();
        PreparedStatement statement = connection.prepareStatement(
                "DELETE FROM clients where date_of_birth > DATE_SUB(CURDATE(), INTERVAL ? YEAR)"
        )){
            statement.setInt(1, age);
            return statement.executeUpdate();
        }
    }

    @SneakyThrows
    @Override
    public List<Client> getClientsWithSumOfOrdersGreaterAndAmountOfGoodsInOrderGreater(int amountOfOrders, int goodsLimit) {
        ArrayList<Client> clients = new ArrayList<>();
        try (Connection connection = createConnection();
        PreparedStatement statement = connection.prepareStatement(
                """
                        SELECT clients.client_id as client_id, date_of_birth, first_name, last_name FROM clients RIGHT JOIN (
                            SELECT COUNT(*) as orders_amount, client_id FROM orders RIGHT JOIN (
                                SELECT COUNT(*) as goods_count, orders.order_id
                                FROM orders JOIN orders_goods ON orders.order_id = orders_goods.order_id
                                GROUP BY orders.order_id HAVING goods_count > ?
                            ) AS goods_filtered ON orders.order_id = goods_filtered.order_id GROUP BY client_id HAVING orders_amount > ?
                        ) AS orders_filtered ON clients.client_id = orders_filtered.client_id"""
        )) {
            statement.setInt(1, goodsLimit);
            statement.setInt(2, amountOfOrders);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                clients.add(extractClientFromResultSet(resultSet));
            }
        }
        return clients;
    }

    private Client extractClientFromResultSet(ResultSet resultSet) throws SQLException {
        Client client = new Client();
        client.setId(resultSet.getString("client_id"));
        client.setFirstName(resultSet.getString("first_name"));
        client.setLastName(resultSet.getString("last_name"));
        client.setDateOfBirth(resultSet.getDate("date_of_birth").toLocalDate());
        return client;
    }
}
