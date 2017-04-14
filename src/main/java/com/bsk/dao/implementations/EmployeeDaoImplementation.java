package com.bsk.dao.implementations;

import com.bsk.dao.AbstractDao;
import com.bsk.dao.interfaces.EmployeeDao;
import com.bsk.entities.Employee;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Mitrius on 03.04.17.
 */
@Repository("employeeDao")
public class EmployeeDaoImplementation extends AbstractDao<Integer, Employee> implements EmployeeDao {
    @Override
    public Employee findByID(Integer id) {
        Employee employee = getByKey(id);
        if (employee != null) {
            Hibernate.initialize(employee.getTransactions());
        }
        return employee;
    }

    @Override
    public void save(Employee employee) {
        persist(employee);
    }

    @Override
    public List<Employee> findAllEmployees() {
        Criteria criteria = createEntityCriteria();
        List temp = criteria.list();
        return (List<Employee>) criteria.list();
    }
}
