package com.qfedu.service.impl;

import com.qfedu.domain.User;
import com.qfedu.mapper.UserMapper;
import com.qfedu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper mapper;

    @Override
    public int save(User user) {
        int i = mapper.insert(user);

        return i;
    }
}
