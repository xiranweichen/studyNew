package com.study.meite.boot.manyDataSource.datasource1;

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
public class User1Service {

    @Autowired
    private User1Mapper mapper;

    @Transactional(transactionManager = "testTransactionManager") //要指定事务管理器
    public int insertUser(String userName, Integer userAge) {
        int result = mapper.insert(userName, userAge);
        int i = 1 / userAge;
        log.info("添加结果是:{}", result);
        return result;
    }

}
