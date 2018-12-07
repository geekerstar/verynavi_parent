package com.verynavi.search;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import util.IdWorker;


@SpringBootApplication
@EnableEurekaClient
public class SearchApplication {

    /**
     * 搜索的启动类
     *
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(SearchApplication.class, args);
    }

    @Bean
    public IdWorker idWorker() {
        // 一个代表机器，一个代表服务
        return new IdWorker(1, 1);
    }

}
