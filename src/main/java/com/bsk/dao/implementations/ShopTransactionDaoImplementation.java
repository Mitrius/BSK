package com.bsk.dao.implementations;

import com.bsk.dao.AbstractDao;
import com.bsk.dao.interfaces.ShopTransactionDao;
import com.bsk.entities.ShopTransaction;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Mitrius on 03.04.17.
 */
@Repository("shopTransactionDao")
public class ShopTransactionDaoImplementation extends AbstractDao<Integer, ShopTransaction>
        implements ShopTransactionDao {
    @Override
    public ShopTransaction findByID(Integer id) {
        ShopTransaction transaction = getByKey(id);
        if (transaction != null) {
            Hibernate.initialize(transaction.getRentals());
        }
        return transaction;
    }

    @Override
    public Integer convertToKeyType(String key) {
        return Integer.parseInt(key);
    }
    @Override
    public void save(ShopTransaction shopTransaction) {
        persist(shopTransaction);
    }

    @Override
    public List<ShopTransaction> findAll() {
        Criteria criteria = createEntityCriteria();
        return (List<ShopTransaction>) criteria.list();
    }
}