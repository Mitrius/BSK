package com.bsk.services;

import com.bsk.dao.interfaces.UserDao;
import com.bsk.dao.interfaces.VideoDao;
import com.bsk.entities.User;
import com.bsk.entities.Video;
import com.sun.org.apache.xpath.internal.operations.Bool;
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

    public User getByID(Integer id) {
        return userDao.findByID(id);
    }

    public void registerUser(Integer id, String password){
        PasswordEncoder pe = new BCryptPasswordEncoder();
        String hash = pe.encode(password);
        User user = new User();
        user.setPassword(hash);
        user.setClearanceLevel(4);
        user.setRole("USER");
        user.setEnabled(true);
        userDao.save(user);
    }

    public List<User> getAllUsers() {
        List<User> temp = userDao.findAllUsers();
        return temp;
    }

}
