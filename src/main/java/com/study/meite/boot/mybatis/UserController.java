package com.study.meite.boot.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lizhenhong
 * @Description:
 * @date 2020/7/18 16:30
 */
@RestController
@RequestMapping("/userForMybatis")
public class UserController {

    @Autowired
    private UserService service;

    @RequestMapping("/insertUser")
    public int insertUser(@RequestBody User user) {
        String userName = user.getUserName();
        Integer userAge = user.getUserAge();
        return service.insertUser(userName, userAge);
    }

}
