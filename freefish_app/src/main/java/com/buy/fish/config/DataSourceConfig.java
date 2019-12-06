package com.buy.fish.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.web.servlet.resource.ResourceResolver;

import javax.sql.DataSource;

/**
 * @author xinjiakun
 * @title: DataSourceConfig
 * @projectName Freefish
 * @description: TODO
 * @date 2019/12/3 16:09
 */
@Configuration
public class DataSourceConfig {

    @Autowired
    private Environment environment;

    @Autowired
    @Qualifier("dataSource")
    private DataSource dataSource;

    //mysql 数据源
    @Bean(name = "dataSource")
    @ConfigurationProperties(prefix = "spring.datasource.primary")
    public DataSource mysqlDateSource() {
        return DataSourceBuilder.create().build();
    }

    //
    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
//        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
//        sqlSessionFactoryBean.setConfigLocation(resolver.getResource("classpath:mybatis-config.xml"));
//        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:mybatis-mappers/*.xml"));
//        sqlSessionFactoryBean.setTypeHandlersPackage("com.buy.fish.handler");
        return sqlSessionFactoryBean.getObject();
    }

    @Bean("transactionMangers")//事务管理器
    public DataSourceTransactionManager getdataSourceTransactionManager(){
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate(
            @Qualifier("sqlSessionFactory") SqlSessionFactory sqlSessionFactory
    ){
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
