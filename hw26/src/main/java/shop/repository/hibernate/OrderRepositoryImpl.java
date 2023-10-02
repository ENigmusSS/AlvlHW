package shop.repository.hibernate;

import shop.config.HibernateUtils;
import shop.entity.Order;
import shop.repository.OrderRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.math.BigDecimal;
import java.util.List;

public class OrderRepositoryImpl extends AbstractHibernateRepository<Order> implements OrderRepository {
    protected void init() {
        aClass = Order.class;
    }

    @Override
    public List<Order> getOrdersWithDiscount() {
        EntityManager entityManager = HibernateUtils.getEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Order> query = criteriaBuilder.createQuery(aClass);
        Root<Order> from = query.from(aClass);
        query.select(from).where(criteriaBuilder.greaterThan(from.get("discount"), 0));
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public BigDecimal getTotalAmountForAllOrders() {
        try (EntityManager entityManager = HibernateUtils.getEntityManager()){
            CriteriaBuilder builder = entityManager.getCriteriaBuilder();
            CriteriaQuery<BigDecimal> query = builder.createQuery(BigDecimal.class);
            query.select(builder.sum(query.from(aClass).get("totalPrice")));
            return entityManager.createQuery(query).getSingleResult();
        }
    }
}
