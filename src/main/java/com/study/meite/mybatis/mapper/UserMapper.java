package com.study.meite.mybatis.mapper;

import com.study.meite.mybatis.annotation.ExtInsert;
import com.study.meite.mybatis.annotation.ExtParam;
import com.study.meite.mybatis.annotation.ExtSelect;
import com.study.meite.mybatis.entity.User;

/**
 * @author lizhenhong
 * @Description:
 * @date 2020/7/4 0:38
 */
public interface UserMapper {

    @ExtInsert("insert into user(userName, userAge) values (#{userName}, #{userAge})")
    int insertuser(@ExtParam("userName") String userName, @ExtParam("userAge") Integer userAge);

    @ExtSelect("select * from user where userName = #{userName} and userAge = #{userAge}")
    User selectUser(@ExtParam("userName") String userName, @ExtParam("userAge") Integer userAge);
}
