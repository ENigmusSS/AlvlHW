package shop.repository.hibernate;

import shop.config.HibernateUtils;
import shop.repository.GenericRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import java.util.List;

public abstract class AbstractHibernateRepository<T> implements GenericRepository<T> {
    protected Class<T> aClass;

    public AbstractHibernateRepository() {
        init();
    }

    protected abstract void init();

    @Override
    public T getById(String id) {
        EntityManager entityManager = HibernateUtils.getEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> query = criteriaBuilder.createQuery(aClass);
        Root<T> from = query.from(aClass);
        query.select(from).where(criteriaBuilder.equal(from.get("id"), id));
        return entityManager.createQuery(query).getSingleResult();
    }

    @Override
    public List<T> getAll() {
        EntityManager entityManager = HibernateUtils.getEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> query = criteriaBuilder.createQuery(aClass);
        Root<T> from = query.from(aClass);
        query.select(from);
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void save(T value) {
        EntityManager entityManager = HibernateUtils.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(value);
        entityManager.flush();
        transaction.commit();
    }
}
