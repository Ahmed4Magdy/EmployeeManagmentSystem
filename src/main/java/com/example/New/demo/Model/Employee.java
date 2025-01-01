package com.example.New.demo.Model;

//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
//import org.springframework.data.relational.core.mapping.Table;

//@Table(name="employee")
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String name;
    private double salary;

    @ManyToOne
    //foreign key
    @JoinColumn(name="depatment_id",referencedColumnName = "id")
    @JsonIgnore
    private Department department;

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

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }
}
