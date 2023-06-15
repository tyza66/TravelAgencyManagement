package com.mingliang.travelagencymanagement;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.mingliang.travelagencymanagement.mapper")
public class TravelAgencyManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(TravelAgencyManagementApplication.class, args);
    }

}
