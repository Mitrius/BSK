package com.bsk.dao.interfaces;

import com.bsk.entities.Employee;

import java.util.List;

/**
 * Created by Mitrius on 03.04.17.
 */
public interface EmployeeDao {
    Employee findByID(Integer id);

    void save(Employee employee);

    List<Employee> findAll();
}
