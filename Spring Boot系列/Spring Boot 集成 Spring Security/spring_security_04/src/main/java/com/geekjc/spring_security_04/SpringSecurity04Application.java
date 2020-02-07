package com.geekjc.spring_security_04;

import com.geekjc.spring_security_04.config.MyProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableConfigurationProperties({MyProperties.class})
@EnableTransactionManagement
@SpringBootApplication
public class SpringSecurity04Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurity04Application.class, args);
    }

}
