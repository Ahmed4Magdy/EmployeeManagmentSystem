package com.example.New.demo.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("Employee")
public class Employee {


    @Id
    private int id;
    private String name;
    private double salary;


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }
}
