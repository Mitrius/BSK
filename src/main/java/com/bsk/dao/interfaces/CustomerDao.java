package com.bsk.dao.interfaces;

import com.bsk.entities.Customer;

import java.util.List;

/**
 * Created by Mitrius on 03.04.17.
 */
public interface CustomerDao {
    Customer findByID(Integer id);

    void save(Customer customer);

    List<Customer> findAll();
}
