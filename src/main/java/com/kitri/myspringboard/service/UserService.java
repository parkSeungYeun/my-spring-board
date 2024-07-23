package com.kitri.myspringboard.service;

import com.kitri.myspringboard.domain.User;
import com.kitri.myspringboard.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service

public class UserService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserMapper userMapper;
    public void signup(User user) {
        if (!user.getPassword().equals(user.getPassword2())) throw new RuntimeException("비밀번호가 일치하지 않습니다");

        user.setEnabled(true);
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userMapper.insert(user);
        userMapper.insertAuthority(user.getId(), "ROLE_USER");
    }
}

