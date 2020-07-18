package com.study.meite.boot.mybatis;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lizhenhong
 * @Description:
 * @date 2020/7/18 16:26
 */
@Service
@Slf4j
public class UserService {

    @Autowired
    private UserMapper mapper;

    public int insertUser(String userName, Integer userAge) {
        int result = mapper.insert(userName, userAge);
        log.info("添加结果是:{}", result);
        return result;
    }

}
