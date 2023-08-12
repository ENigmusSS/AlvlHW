package shop.repository.hibernate;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.*;
import shop.config.HibernateUtils;
import shop.entity.Client;
import shop.entity.Order;
import shop.repository.ClientRepository;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;


public class ClientRepositoryImpl extends AbstractHibernateRepository<Client> implements ClientRepository {
    protected void init() {
        aClass = Client.class;
    }

    @Override
    public List<Client> getClientsWithAmountOfOrdersGreater(int amount) {
        try (EntityManager entityManager = HibernateUtils.getEntityManager()) {
            CriteriaBuilder builder = entityManager.getCriteriaBuilder();
            CriteriaQuery<Client> query = builder.createQuery(aClass);
            Root<Client> root = query.from(aClass);
            query.select(root).where(builder.ge(builder.size(root.get("orders")), amount));
            return entityManager.createQuery(query).getResultList();
        }
    }

    @Override
    public int removeAllClientsYoungerThan(int age) {
        try (EntityManager entityManager = HibernateUtils.getEntityManager()) {
            CriteriaBuilder builder = entityManager.getCriteriaBuilder();
            CriteriaDelete<Client> query = builder.createCriteriaDelete(aClass);
            Root<Client> root = query.from(aClass);
            LocalDate maxDate = LocalDate.now().minusYears(age);
            query.where(builder.greaterThan(root.get("dateOfBirth"), Date.valueOf(maxDate)));
            return entityManager.createQuery(query).executeUpdate();
        }
    }

    @Override
    public List<Client> getClientsWithSumOfOrdersGreaterAndAmountOfGoodsInOrderGreater(int amountOfOrders, int goodsLimit) {

        try (EntityManager entityManager = HibernateUtils.getEntityManager()) {
            CriteriaBuilder builder = entityManager.getCriteriaBuilder();
            CriteriaQuery<Client> query = builder.createQuery(aClass);
            Root<Client> clientRoot = query.from(aClass);
            Subquery<Long> orderSubquery = query.subquery(Long.class);
            Root<Order> orderRoot = orderSubquery.from(Order.class);
            orderSubquery.select(builder.count(orderRoot))
                    .where(builder.ge(builder.size(orderRoot.get("goods")), goodsLimit),
                            builder.equal(orderRoot.get("client"), clientRoot));
            query.select(clientRoot).where(builder.ge(orderSubquery, amountOfOrders));
            return entityManager.createQuery(query).getResultList();
        }
    }
}
