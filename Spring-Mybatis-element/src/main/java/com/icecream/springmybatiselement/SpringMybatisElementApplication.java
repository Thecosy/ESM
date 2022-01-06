package com.icecream.springmybatiselement;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.icecream.springmybatiselement.mapper")
public class SpringMybatisElementApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringMybatisElementApplication.class, args);
    }

}
