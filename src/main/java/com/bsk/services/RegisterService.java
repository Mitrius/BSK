package com.bsk.services;

import com.bsk.dao.interfaces.UserDao;
import com.bsk.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("RegisterService")
@Transactional
public class RegisterService {
    @Autowired
    UserDao userDao;

    public void registerUser(User user) {
        PasswordEncoder pe = new BCryptPasswordEncoder();
        String hash = pe.encode(user.getPassword());
        user.setPassword(hash);
        user.setRole("USER"); //Wykluczamy tworzenie adminów (role narzuca Spring Security)
        userDao.save(user);
    }

}
