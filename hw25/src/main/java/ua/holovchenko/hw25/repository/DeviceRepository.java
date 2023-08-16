package ua.holovchenko.hw25.repository;

import ua.holovchenko.hw25.entity.Device;
import ua.holovchenko.hw25.entity.DeviceType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DeviceRepository extends AbstractRepository<Device, Integer> {

    public void createTable() throws SQLException {
        String createTableSQL = """
                CREATE TABLE IF NOT EXISTS Device (
                                          id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                                          type ENUM('SMARTPHONE', 'TV', 'LAPTOP', 'TABLET'),
                                          model VARCHAR(255),
                                          price DECIMAL(9, 2),
                                          productionDate DATE,
                                          description LONGTEXT,
                                          stored BIT,
                                          factoryId INT,
                                          FOREIGN KEY (factoryId) REFERENCES Factory(id)
                  );""";
        try (Connection connection = createConnection();
             PreparedStatement statement = connection.prepareStatement(createTableSQL)){
            statement.execute();
        }
    }

    @Override
    public Optional<Device> getByID(Integer id) throws SQLException {
        try (Connection connection = createConnection();
             PreparedStatement statement = connection.prepareStatement("select * from Device where id = ?")) {
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
    public List<Device> getAll() throws SQLException {
        List<Device> devices = new ArrayList<>();
        try (Connection connection = createConnection();
             PreparedStatement statement = connection.prepareStatement("select * from device")) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    devices.add(extractEntityFromResultSet(resultSet));
                }
            }
        }
        return devices;
    }

    @Override
    public boolean add(Device device) throws SQLException {
        try (Connection connection = createConnection();
             PreparedStatement statement = connection.prepareStatement
                     ("INSERT INTO device " +
                             "(type, model, price, productionDate, description, stored, factoryId) " +
                             "VALUES (?,?,?,?,?,?,?)")) {
            deviceToStatement(device, statement);
            return statement.execute();
        }
    }



    @Override
    public void remove(Integer id) throws SQLException {
        try (Connection connection = createConnection();
             PreparedStatement statement = connection.prepareStatement("delete from device where id = ?")) {
            statement.setInt(1, id);
            statement.execute();
        }
    }

    public void update(Integer id, Device device) throws SQLException {
        try (Connection connection = createConnection();
        PreparedStatement statement = connection.prepareStatement
                ("UPDATE device set type = ?, model = ?, price = ?, productionDate = ?, " +
                        "description = ?, stored = ?, factoryId = ? where id = ?")){
            deviceToStatement(device, statement);
            statement.setInt(8, id);
                statement.execute();
        }
    }

    public List<Device> getDevicesByFactory(int factoryID) throws SQLException {
        ArrayList<Device> devices = new ArrayList<>();
        try (Connection connection = createConnection();
        PreparedStatement statement = connection.prepareStatement
                ("SELECT * FROM device JOIN factory ON factoryId = factory.id AND factory.id = ?")){
            statement.setInt(1, factoryID);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    devices.add(extractEntityFromResultSet(resultSet));
                    System.out.println(
                            resultSet.getInt(1)
                            +" "+ resultSet.getString(2)
                            +" "+ resultSet.getString(3)
                            +" "+ resultSet.getBigDecimal(4)
                            +" "+ resultSet.getDate(5)
                            +" "+ resultSet.getString(6)
                            +" "+ resultSet.getBoolean(7)
                            +" "+ resultSet.getInt(8)
                            +" "+ resultSet.getString(10)
                            +" "+ resultSet.getString(11)
                    );
                }
            }
        }
        return devices;
    }

    private static Device extractEntityFromResultSet(ResultSet resultSet) throws SQLException {
        Device device = new Device();
        device.setId(resultSet.getInt("id"));
        device.setType(DeviceType.valueOf(resultSet.getString("type")));
        device.setModel(resultSet.getString("model"));
        device.setPrice(resultSet.getBigDecimal("price"));
        device.setProductionDate(resultSet.getDate("productionDate"));
        device.setDescription(resultSet.getString("description"));
        device.setStored(resultSet.getBoolean("stored"));
        device.setFactoryId(resultSet.getInt("factoryId"));
        return device;
    }

    private static void deviceToStatement(Device device, PreparedStatement statement) throws SQLException {
        statement.setString(1, device.getType().name());
        statement.setString(2, device.getModel());
        statement.setBigDecimal(3, device.getPrice());
        statement.setDate(4, device.getProductionDate());
        statement.setString(5, device.getDescription());
        statement.setBoolean(6, device.isStored());
        statement.setInt(7, device.getFactoryId());
    }
}
