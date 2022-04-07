package com.rky.mall.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * MyBatis配置类
 * @date 2022/4/1
 */
@Configuration
@MapperScan({"com.rky.mall.mbg.mapper", "com.rky.mall.dao"})
public class MyBatisConfig {
}
