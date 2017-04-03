package com.bsk.dao.implementations;

import com.bsk.dao.AbstractDao;
import com.bsk.dao.interfaces.CustomerDao;
import com.bsk.entities.Customer;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Mitrius on 03.04.17.
 */
@Repository("customerDao")
public class CustomerDaoImplementation extends AbstractDao<Integer, Customer> implements CustomerDao {
    @Override
    public Customer findByID(Integer id) {
        Customer customer = getByKey(id);
        if (customer != null) {
            Hibernate.initialize(customer.getTransactions());
        }
        return customer;
    }

    @Override
    public void save(Customer customer) {
        persist(customer);
    }

    @Override
    public List<Customer> findAllCustomers() {
        Criteria criteria = createEntityCriteria();
        List temp = criteria.list();
        return (List<Customer>) criteria.list();
    }
}
