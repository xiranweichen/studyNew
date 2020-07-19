package com.study.meite.boot.manyDataSource.datasource2;

import com.study.meite.boot.mybatis.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author lizhenhong
 * @Description:
 * @date 2020/7/18 16:25
 */
public interface UsersMapper {
    @Select("SELECT * FROM USERS WHERE NAME = #{username}")
    User findByName(@Param("username") String username);

    @Insert("INSERT INTO USERS(userName, password, realname) VALUES(#{userName}, #{password},#{realname})")
    int insert(@Param("userName") String userName, @Param("password") String password, @Param("realname") String realname);
}
