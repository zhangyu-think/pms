package com.pznsh.pms.config;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;

import javax.sql.DataSource;

@SpringBootConfiguration
public class SessionFactoryConfiguration {
    @Autowired
    private DataSource dataSource;
    public SqlSessionFactoryBean createSqlSessionFactory(){
        SqlSessionFactoryBean factoryBean=new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        return factoryBean;
    }
}
