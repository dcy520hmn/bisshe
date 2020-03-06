package com.keji;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan({"com.keji.mapper"})
public class StorePssApplication {

    public static void main(String[] args) {
        SpringApplication.run(StorePssApplication.class, args);
    }

}
