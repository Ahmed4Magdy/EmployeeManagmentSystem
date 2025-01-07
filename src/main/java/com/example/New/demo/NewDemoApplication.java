package com.example.New.demo;

import com.example.New.demo.Model.Employee;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.List;

@SpringBootApplication
@EnableTransactionManagement

public class NewDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(NewDemoApplication.class, args);
    }



}
