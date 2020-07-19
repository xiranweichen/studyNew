package com.study.meite.boot.manyDataSource.datasource1;

import com.study.meite.boot.mybatis.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author lizhenhong
 * @Description:
 * @date 2020/7/18 16:25
 */
public interface User1Mapper {
    @Select("SELECT * FROM USER WHERE NAME = #{name}")
    User findByName(@Param("name") String name);
    @Insert("INSERT INTO USER(userName, userAge) VALUES(#{userName}, #{userAge})")
    int insert(@Param("userName") String userName, @Param("userAge") Integer userAge);
}
