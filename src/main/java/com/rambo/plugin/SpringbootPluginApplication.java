package com.rambo.plugin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@MapperScan("com.rambo.plugin.module")
public class SpringbootPluginApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootPluginApplication.class, args);
    }
}
