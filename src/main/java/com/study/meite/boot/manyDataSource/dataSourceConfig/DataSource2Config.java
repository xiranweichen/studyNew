package com.study.meite.boot.manyDataSource.dataSourceConfig;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @author lizhenhong
 * @Description: 配置users数据库数据源
 * @date 2020/7/19 15:32
 */
@Configuration // 注册到springboot容器中
@MapperScan(basePackages = "com.study.meite.boot.manyDataSource.datasource2", sqlSessionFactoryRef = "usersSqlSessionFactory")
public class DataSource2Config {

    /**
     * @methodDesc: 功能描述:(配置users数据库)
     */
    @Bean(name = "usersDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.users")
    public DataSource testDataSource() {
        return DataSourceBuilder.create().build();
    }

    /**
     * @methodDesc: 功能描述:(users sql会话工厂)
     */
    @Bean(name = "usersSqlSessionFactory")
    public SqlSessionFactory testSqlSessionFactory(@Qualifier("usersDataSource") DataSource dataSource)
            throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        //如果需要加载mapper.xml文件，可以需要把下面的注解放开
        // bean.setMapperLocations(
        // new
        // PathMatchingResourcePatternResolver().getResources("classpath:mybatis/mapper/users/*.xml"));
        return bean.getObject();
    }

    /**
     * @methodDesc: 功能描述:(users 事物管理)
     */
    @Bean(name = "usersTransactionManager")
    public DataSourceTransactionManager testTransactionManager(@Qualifier("usersDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "usersSqlSessionTemplate")
    public SqlSessionTemplate testSqlSessionTemplate(
            @Qualifier("usersSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
