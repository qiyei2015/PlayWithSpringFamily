package com.qiyei.spring.demo;

import lombok.Builder;
import lombok.Data;

/**
 * @author Created by qiyei2015 on 2020/8/5.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description:
 */
@Data
@Builder
public class Foo {
    private Long id;
    private String bar;
}
