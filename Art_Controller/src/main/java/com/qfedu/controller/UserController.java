package com.qfedu.controller;

import com.qfedu.common.result.R;
import com.qfedu.domain.User;
import com.qfedu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
    @Autowired
    private UserService service;

    @RequestMapping
    @ResponseBody
    public R useradd(User user) {
        int i = service.save(user);

        if (i > 0) {
            return new R(0,"成功",null);
        } else {
            return new R(1,"失败",null);
        }
    }
}
