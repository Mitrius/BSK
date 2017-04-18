package com.bsk.dao.implementations;

import com.bsk.dao.AbstractDao;
import com.bsk.dao.interfaces.EmployeeDao;
import com.bsk.entities.Employee;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Mitrius on 03.04.17.
 */
@Repository("employeeDao")
public class EmployeeDaoImplementation extends AbstractDao<Integer, Employee> implements EmployeeDao {

    @Override
    public Integer convertToKeyType(String key) {
        return Integer.parseInt(key);
    }
    @Override
    public void save(Employee employee) {
        persist(employee);
    }

    @Override
    public List<Employee> findAll() {
        Criteria criteria = createEntityCriteria();
        List temp = criteria.list();
        return (List<Employee>) criteria.list();
    }
}
