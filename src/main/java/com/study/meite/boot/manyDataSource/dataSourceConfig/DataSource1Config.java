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
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @author lizhenhong
 * @Description: 配置test数据库的数据源
 * @date 2020/7/19 15:27
 */
@Configuration // 注册到springboot容器中
@MapperScan(basePackages = "com.study.meite.boot.manyDataSource.datasource1", sqlSessionFactoryRef = "testSqlSessionFactory")
public class DataSource1Config {

    /**
     * 功能描述:(配置test数据库)
     */
    @Bean(name = "testDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.test")  //读到配置文件中的相关配置(spring.datasource.test.#######)
    @Primary
    public DataSource testDataSource() {
        return DataSourceBuilder.create().build();
    }

    /**
     *
     * 功能描述:(test sql会话工厂)
     */
    @Bean(name = "testSqlSessionFactory")
    @Primary
    public SqlSessionFactory testSqlSessionFactory(@Qualifier("testDataSource") DataSource dataSource)
            throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        // bean.setMapperLocations(
        // new
        // PathMatchingResourcePatternResolver().getResources("classpath:mybatis/mapper/test/*.xml"));
        return bean.getObject();
    }

    /**
     *
     * @methodDesc: 功能描述:(test 事物管理)
     */
    @Bean(name = "testTransactionManager")
    @Primary
    public DataSourceTransactionManager testTransactionManager(@Qualifier("testDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "testSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate testSqlSessionTemplate(
            @Qualifier("testSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
