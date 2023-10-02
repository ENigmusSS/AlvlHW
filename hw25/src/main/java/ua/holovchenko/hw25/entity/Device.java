package ua.holovchenko.hw25.entity;

import lombok.*;

import java.math.BigDecimal;
import java.sql.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode
public class Device {
    private int id;
    private DeviceType type;
    private String model;
    private BigDecimal price;
    private Date productionDate;
    private String description;
    private boolean stored;
    private int factoryId;

    public Device(DeviceType type, String model, BigDecimal price, Date productionDate, String description, boolean stored, int factoryId) {
        this.type = type;
        this.model = model;
        this.price = price;
        this.productionDate = productionDate;
        this.description = description;
        this.stored = stored;
        this.factoryId = factoryId;
    }
}
