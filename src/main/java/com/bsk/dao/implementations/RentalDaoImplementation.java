package com.bsk.dao.implementations;

import com.bsk.dao.AbstractDao;
import com.bsk.dao.interfaces.RentalDao;
import com.bsk.entities.Rental;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Mitrius on 03.04.17.
 */
@Repository("rentalDao")
public class RentalDaoImplementation extends AbstractDao<Integer, Rental> implements RentalDao {
    @Override
    public Rental findByID(Integer id) {
        return getByKey(id);
    }
    @Override
    public Integer convertToKeyType(String key) {
        return Integer.parseInt(key);
    }

    @Override
    public void save(Rental rental) {
        persist(rental);
    }

    @Override
    public List<Rental> findAll() {
        Criteria criteria = createEntityCriteria();
        return (List<Rental>) criteria.list();
    }
}
