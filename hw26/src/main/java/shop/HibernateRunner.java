package shop;

import shop.entity.Client;
import shop.entity.Goods;
import shop.entity.Order;
import shop.repository.ClientRepository;
import shop.repository.GoodsRepository;
import shop.repository.OrderRepository;
import shop.repository.hibernate.ClientRepositoryImpl;
import shop.repository.hibernate.GoodsRepositoryImpl;
import shop.repository.hibernate.OrderRepositoryImpl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class HibernateRunner {
    private static final ClientRepository clientRepository = new ClientRepositoryImpl();
    private static final GoodsRepository goodsRepository = new GoodsRepositoryImpl();
    private static final OrderRepository orderRepository = new OrderRepositoryImpl();

    public static void main(String[] args) {
        Client client = createAndSaveClient();
        clientRepository.getAll().forEach(System.out::println);
        Goods goods = createAndSaveGoods();
        goodsRepository.getAll().forEach(System.out::println);
        Order order = createAndSaveOrder(client, goods);
        orderRepository.getAll().forEach(System.out::println);

        System.out.println(orderRepository.getOrdersWithDiscount());
        System.out.println(clientRepository.getClientsWithSumOfOrdersGreaterAndAmountOfGoodsInOrderGreater(0,0));
    }

    private static Client createAndSaveClient() {
        Client client = new Client("Tester", "Testerov", LocalDate.of(2022, 11, 29));
        clientRepository.save(client);
        return client;
    }

    private static Goods createAndSaveGoods() {
        Goods goods = new Goods(BigDecimal.valueOf(2000), "Test goods", "Test category");
        goodsRepository.save(goods);
        return goods;
    }

    private static Order createAndSaveOrder(Client client, Goods goods) {
        Order order = new Order(LocalDateTime.now(), goods.getPrice(), null);
        order.setGoods(List.of(goods));
        order.setClient(client);
        orderRepository.save(order);
        return order;
    }
}
