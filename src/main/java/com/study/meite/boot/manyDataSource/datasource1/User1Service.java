package com.study.meite.boot.manyDataSource.datasource1;

import com.study.meite.boot.manyDataSource.datasource2.UsersMapper;
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
    @Autowired
    private UsersMapper usersMapper;

    @Transactional(transactionManager = "testTransactionManager") //要指定事务管理器
    public int insertUser(String userName, Integer userAge) {
        int result = mapper.insert(userName, userAge);
        int i = 1 / userAge;
        log.info("添加结果是:{}", result);
        return result;
    }

    @Transactional(transactionManager = "testTransactionManager")  //由于这里指定的事务处理器是test数据库的，所以只对test有效，对其他的无效。结果就是test插入失败，另一个插入成功
    public int testUsersAndUser(User1 user1) {
        int result1 = mapper.insert(user1.getUserName(), user1.getUserAge());
        int result2 = usersMapper.insert(user1.getUserName(), "11111", "lizhenhong");
        int i = 1 / 0;
        int result = result1 + result2;
        return result;
    }
}
