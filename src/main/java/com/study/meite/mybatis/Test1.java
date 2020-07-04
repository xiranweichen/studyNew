package com.study.meite.mybatis;

import com.study.meite.mybatis.entity.User;
import com.study.meite.mybatis.mapper.UserMapper;
import com.study.meite.mybatis.sql.SqlSession;
import org.junit.Test;

/**
 * @author lizhenhong
 * @Description:
 * @date 2020/7/4 1:21
 */
public class Test1 {

    /**
     * 使用动态代理技术虚拟调用方法
     */
    //新增
    @Test
    public void testInsert() throws IllegalAccessException, InstantiationException {
        UserMapper mapper = SqlSession.getMapper(UserMapper.class);
        //先走拦截invoke
        int result = mapper.insertuser("lizhenhong", 18);
        System.out.println("新增user表的结果是：" + result);
    }

    //查询
    @Test
    public void testSelect() throws IllegalAccessException, InstantiationException {
        UserMapper mapper = SqlSession.getMapper(UserMapper.class);
        User user = mapper.selectUser("lizhenhong", 18);
        System.out.println("查询到的user信息：" + user.toString());
    }

}
