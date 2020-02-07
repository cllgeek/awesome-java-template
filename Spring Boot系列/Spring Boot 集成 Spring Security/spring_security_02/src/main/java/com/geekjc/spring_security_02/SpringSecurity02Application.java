package com.geekjc.spring_security_02;

import com.geekjc.spring_security_02.config.MyProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableConfigurationProperties({MyProperties.class})
@EnableTransactionManagement
@SpringBootApplication
public class SpringSecurity02Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurity02Application.class, args);
    }

}
