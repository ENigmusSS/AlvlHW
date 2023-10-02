package shop.repository.hibernate;

import shop.entity.Goods;
import shop.repository.GoodsRepository;

public class GoodsRepositoryImpl extends AbstractHibernateRepository<Goods> implements GoodsRepository {
    protected void init() {
        aClass = Goods.class;
    }
}
