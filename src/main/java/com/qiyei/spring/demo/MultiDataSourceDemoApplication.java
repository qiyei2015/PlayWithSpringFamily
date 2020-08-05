//package com.qiyei.spring.demo;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
//import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
//import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
//import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.jdbc.datasource.DataSourceTransactionManager;
//import org.springframework.transaction.PlatformTransactionManager;
//
//import javax.annotation.Resource;
//
///**
// * @author Created by qiyei2015 on 2020/8/4.
// * @version: 1.0
// * @email: 1273482124@qq.com
// * @description:
// */
//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, DataSourceTransactionManagerAutoConfiguration.class, JdbcTemplateAutoConfiguration.class})
//@Slf4j
//public class MultiDataSourceDemoApplication {
//
//    private static final String TAG = "HAN_DAN ";
//
//    public static void main(String[] args) {
//        SpringApplication.run(MultiDataSourceDemoApplication.class, args);
//    }
//
//    @Bean
//    @ConfigurationProperties("foo.datasource")
//    public DataSourceProperties fooDataSourceProperties(){
//        return new DataSourceProperties();
//    }
//
//    @Bean
//    public DataSource fooDataSource(){
//        DataSourceProperties dataSourceProperties = fooDataSourceProperties();
//        log.info(TAG + "foo= " + dataSourceProperties.getUrl());
//        return dataSourceProperties.initializeDataSourceBuilder().build();
//    }
//
//    @Bean
//    @Resource
//    public PlatformTransactionManager fooTxManager(@Qualifier("fooDataSource")DataSource dataSource){
//        return new DataSourceTransactionManager(dataSource);
//    }
//
//    @Bean
//    @ConfigurationProperties("bar.datasource")
//    public DataSourceProperties barDataSourceProperties(){
//        return new DataSourceProperties();
//    }
//
//    @Bean
//    public DataSource barDataSource(){
//        DataSourceProperties dataSourceProperties = barDataSourceProperties();
//        log.info(TAG + "bar= " + dataSourceProperties.getUrl());
//        return dataSourceProperties.initializeDataSourceBuilder().build();
//    }
//
//    @Bean
//    @Resource
//    public PlatformTransactionManager barTxManager(@Qualifier("barDataSource") DataSource dataSource){
//        return new DataSourceTransactionManager(dataSource);
//    }
//}
