package com.bsk.services;

import com.bsk.dao.interfaces.UserDao;
import com.bsk.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Krystian on 14.04.2017.
 */
@Service("RegisterService")
@Transactional
public class RegisterService {
    @Autowired
    UserDao userDao;

    public User getByID(String id) {
        return userDao.findByID(id);
    }

    public void registerUser(String username, String password) {
        PasswordEncoder pe = new BCryptPasswordEncoder();
        String hash = pe.encode(password);
        User user = new User();
        user.setUsername(username);
        user.setPassword(hash);
        user.setClearanceLevel(4);
        user.setRole("USER");
        user.setEnabled(true);
        userDao.save(user);
    }

    public List<User> getAllUsers() {
        return userDao.findAll();
    }

}
