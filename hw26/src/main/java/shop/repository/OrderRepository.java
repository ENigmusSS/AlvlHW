package shop.repository;

import shop.entity.Order;

import java.math.BigDecimal;
import java.util.List;

public interface OrderRepository extends GenericRepository<Order> {
    List<Order> getOrdersWithDiscount();
    BigDecimal getTotalAmountForAllOrders();
}
