package com.study.meite.boot.manyDataSource.datasource1;

import com.study.meite.boot.mybatis.User;
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
@RequestMapping("/userForDataSource1")
public class User1Controller {

    @Autowired
    private User1Service service;

    @RequestMapping("/insertUser")
    public int insertUser(@RequestBody User1 user) {
        String userName = user.getUserName();
        Integer userAge = user.getUserAge();
        return service.insertUser(userName, userAge);
    }

}
