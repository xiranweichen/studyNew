package com.study.meite.boot.manyDataSource.datasource2;

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
@RequestMapping("/usersForDataSource2")
public class UsersController {

    @Autowired
    private UsersService service;

    @RequestMapping("/insertUser")
    public int insertUser(@RequestBody Users user) {
        String userName = user.getUsername();
        String password = user.getPassword();
        String realname = user.getRealname();
        return service.insertUser(userName, password, realname);
    }

}
