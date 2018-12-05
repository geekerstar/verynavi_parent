package com.verynavi.manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author geekerstar
 * @date 2018/12/5
 * description
 */

@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
public class ManagerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ManagerApplication.class);
    }
}
