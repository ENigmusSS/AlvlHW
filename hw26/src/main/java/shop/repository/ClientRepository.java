package shop.repository;

import shop.entity.Client;

import java.util.List;

public interface ClientRepository extends GenericRepository<Client> {
    List<Client> getClientsWithAmountOfOrdersGreater(int amount);

    int removeAllClientsYoungerThan(int age);

    List<Client> getClientsWithSumOfOrdersGreaterAndAmountOfGoodsInOrderGreater(int amountOfOrders, int goodsLimit);
}
