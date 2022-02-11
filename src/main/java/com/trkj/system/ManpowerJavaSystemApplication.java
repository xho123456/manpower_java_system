package com.trkj.system;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@MapperScan("com.example.**.mapper")
public class ManpowerJavaSystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(ManpowerJavaSystemApplication.class, args);
    }

}
