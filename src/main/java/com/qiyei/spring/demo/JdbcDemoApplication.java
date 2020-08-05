package com.qiyei.spring.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import javax.sql.DataSource;

/**
 * @author Created by qiyei2015 on 2020/8/5.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description:
 */
@SpringBootApplication
@Slf4j
public class JdbcDemoApplication implements CommandLineRunner {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private FooDao mFooDao;

    @Autowired
    private BatchFooDao mBatchFooDao;

    public static void main(String[] args) {
        SpringApplication.run(JdbcDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info(dataSource.toString());
        mFooDao.insertData();
        mBatchFooDao.batchInsert();
        mFooDao.listData();
    }

    @Bean
    @Autowired
    public SimpleJdbcInsert simpleJdbcInsert(JdbcTemplate jdbcTemplate){
        return new SimpleJdbcInsert(jdbcTemplate).withTableName("Foo").usingGeneratedKeyColumns("ID");
    }

    @Bean
    @Autowired
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate(DataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);
    }

}
