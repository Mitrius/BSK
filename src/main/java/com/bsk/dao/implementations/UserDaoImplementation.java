package com.bsk.dao.implementations;

import com.bsk.dao.AbstractDao;
import com.bsk.dao.interfaces.UserDao;
import com.bsk.entities.User;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Mitrius on 03.04.17.
 */
@Repository("userDao")
public class UserDaoImplementation extends AbstractDao<String, User> implements UserDao {
    @Override
    public User findByID(String id) {
        return getByKey(id);
    }

    @Override
    public void save(User user) {
        persist(user);
    }

    @Override
    public List<User> findAll() {
        Criteria criteria = createEntityCriteria();
        return (List<User>) criteria.list();
    }
}
