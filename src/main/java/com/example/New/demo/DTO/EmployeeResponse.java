package com.example.New.demo.DTO;

import com.example.New.demo.Model.Department;
import com.example.New.demo.Model.User;
import jakarta.persistence.*;

public class EmployeeResponse {


    private Long id;
    private String name;
    private double salary;


    private Department department;


    private User user;


    public Department getDepartment() {
        return department;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }
}



