package com.geekjc.resubmit;

import com.geekjc.resubmit.config.MyProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableConfigurationProperties({MyProperties.class})
@EnableTransactionManagement
@SpringBootApplication
public class ResubmitApplication {

    public static void main(String[] args) {
        SpringApplication.run(ResubmitApplication.class, args);
    }

}
