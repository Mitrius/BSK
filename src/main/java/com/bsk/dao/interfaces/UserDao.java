package com.bsk.dao.interfaces;

import com.bsk.entities.User;

import java.util.List;

/**
 * Created by Mitrius on 03.04.17.
 */
public interface UserDao {
    User findByID(String id);

    void save(User user);

    List<User> findAllUsers();
}
