package com.qiyei.spring.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Created by qiyei2015 on 2020/8/5.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description:
 */
@Repository
public class BatchFooDao {

    @Autowired
    private JdbcTemplate mJdbcTemplate;
    @Autowired
    private NamedParameterJdbcTemplate mNamedParameterJdbcTemplate;

    public void batchInsert(){
        mJdbcTemplate.batchUpdate("insert into Foo (BAR) values (?)", new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
                preparedStatement.setString(1,"b-" + i);
            }

            @Override
            public int getBatchSize() {
                return 10;
            }
        });
        List<Foo> list = new ArrayList<>();
        list.add(Foo.builder().id(100L).bar("bar-100").build());
        list.add(Foo.builder().id(101L).bar("bar-101").build());
        mNamedParameterJdbcTemplate.batchUpdate("insert into FOO (ID,BAR) values(:id,:bar)", SqlParameterSourceUtils.createBatch(list));
    }



}
