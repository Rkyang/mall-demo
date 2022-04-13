package com.rky.mall.component;

import cn.hutool.core.date.LocalDateTimeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class TestSpringTask {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestSpringTask.class);

    /**
     * 每一分钟在控制台打印一次日志信息
     */
    @Scheduled(cron = "0 0/1 * ? * ?")
    private void printTask() {
        LOGGER.info("执行了一次定时打印任务：{}", LocalDateTimeUtil.format(LocalDateTime.now(), "yyyy-MM-dd HH:mm:ss"));
    }
}
