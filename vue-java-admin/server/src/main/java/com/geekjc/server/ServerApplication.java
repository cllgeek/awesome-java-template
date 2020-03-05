package com.geekjc.server;

import com.geekjc.server.config.MyProperties;
import com.geekjc.server.utils.ApplicationContextUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableConfigurationProperties({MyProperties.class})
@EnableTransactionManagement
@SpringBootApplication
public class ServerApplication {

    public static void main(String[] args) {
       ApplicationContext app = SpringApplication.run(ServerApplication.class, args);
       ApplicationContextUtil.setApplicationContext(app);
    }

}