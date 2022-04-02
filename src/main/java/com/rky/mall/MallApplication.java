package com.rky.mall;

import com.alibaba.druid.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.net.UnknownHostException;

@SpringBootApplication
public class MallApplication {

    public static Logger LOGGER = LoggerFactory.getLogger(MallApplication.class);

    public static void main(String[] args) throws UnknownHostException {
        ConfigurableApplicationContext run = SpringApplication.run(MallApplication.class, args);

        // 将访问地址输出到控制台
        Environment env = run.getEnvironment();
        String ip = InetAddress.getLocalHost().getHostAddress();
        String port = env.getProperty("server.port");
        String path = env.getProperty("server.servlet.context-path");
        if (StringUtils.isEmpty(path)) {
            path = "";
        }
        LOGGER.info("\n----------------------------------------------------------\n\t" +
                "Application  is running! Access URLs:\n\t" +
                "Local访问网址: \t\thttp://localhost:" + port + path + "\n\t" +
                "External访问网址: \thttp://" + ip + ":" + port + path + "\n\t" +
                "----------------------------------------------------------");
    }

}
