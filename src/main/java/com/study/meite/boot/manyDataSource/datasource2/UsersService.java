package com.study.meite.boot.manyDataSource.datasource2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author lizhenhong
 * @Description:
 * @date 2020/7/18 16:26
 */
@Service
@Slf4j
public class UsersService {

    @Autowired
    private UsersMapper mapper;

    @Transactional(transactionManager = "usersTransactionManager") //要指定事务管理器
    public int insertUser(String username, String password, String realname) {
        int result = mapper.insert(username, password, realname);
//        int i = 1 / 0;
        log.info("添加结果是:{}", result);
        return result;
    }

}
