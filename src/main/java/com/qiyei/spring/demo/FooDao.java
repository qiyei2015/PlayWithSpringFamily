package com.qiyei.spring.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Created by qiyei2015 on 2020/8/5.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description:
 */
@Repository
@Slf4j
public class FooDao {
    @Autowired
    private JdbcTemplate mJdbcTemplate;
    @Autowired
    private SimpleJdbcInsert mSimpleJdbcInsert;

    public void insertData() {
        Arrays.asList("b", "c", "d").forEach(it -> mJdbcTemplate.update("insert into Foo (BAR) values (?)", it));

        Map<String,String> row = new HashMap<>();
        row.put("BAR","e");
        Number id = mSimpleJdbcInsert.executeAndReturnKey(row);
        log.info("FOODAO id of e = " + id.longValue());
    }

    public void listData(){
        log.info("count Foo = " + mJdbcTemplate.queryForObject("select count(*) from FOO",Long.class));

        List<String> barList = mJdbcTemplate.queryForList("select BAR from FOO",String.class);
        barList.forEach(it -> log.info("BAR=" + it));

        List<Foo> fooList = mJdbcTemplate.query("select * from FOO", new RowMapper<Foo>() {
            @Override
            public Foo mapRow(ResultSet resultSet, int i) throws SQLException {
                return Foo.builder()
                        .id(resultSet.getLong(1))
                        .bar(resultSet.getString(2))
                        .build();
            }
        });
        fooList.forEach(it -> log.info("Foo=" + it));
    }
}
