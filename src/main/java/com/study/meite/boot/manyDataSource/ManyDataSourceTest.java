package com.study.meite.boot.manyDataSource;

import com.study.meite.boot.manyDataSource.datasource1.User1;
import com.study.meite.boot.manyDataSource.datasource1.User1Service;
import com.study.meite.boot.manyDataSource.datasource2.Users;
import com.study.meite.boot.manyDataSource.datasource2.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lizhenhong
 * @Description: 测试多数据源
 * @date 2020/7/19 16:05
 */
@RestController
public class ManyDataSourceTest {

    @Autowired
    private User1Service user1Service;
    @Autowired
    private UsersService usersService;

    @RequestMapping("/getDataSource1")
    public String getDataSource1(@RequestBody User1 user1) {
        int result = user1Service.insertUser(user1.getUserName(), user1.getUserAge());
        return result > 0 ? "添加成功" : "添加失败";
    }

    @RequestMapping("/getDataSource2")
    public String getDataSource2(@RequestBody Users users) {
        int result = usersService.insertUser(users.getUsername(), users.getPassword(), users.getRealname());
        return result > 0 ? "添加成功" : "添加失败";
    }

}
