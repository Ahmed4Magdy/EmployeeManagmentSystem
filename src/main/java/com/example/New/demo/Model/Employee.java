package com.example.New.demo.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import javax.xml.crypto.Data;
import java.util.Date;

@Table(name = "actor")
@Entity
//@NamedQuery(name = "Employee.findBySalary", query = "select emp from Employee emp where emp.salary>=:salary")
//
//@NamedNativeQuery(name = "Employee.findByDepartment", query = "select *from employee where department_id=:deptid")


public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "actor_id")
    private Long id;
    @Column(name = "first_name")
    private String firstname;
    @Column(name = "last_name")
    private String lastname;
    private Date last_update;


    @ManyToOne()
    @JoinColumn(name = "depatment_id")
//    @JsonIgnore
    private Department department;


    @OneToOne()
    @JoinColumn(name = "user_id")
    private User user;

    public Employee() {

    }

    public Employee(Long id, String firstname, String lastname) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public Long getId() {
        return id;
    }

    public String getLastname() {
        return lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public Date getLast_update() {
        return last_update;
    }

    public Department getDepartment() {
        return department;
    }

    public User getUser() {
        return user;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setLast_update(Date last_update) {
        this.last_update = last_update;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public void setUser(User user) {
        this.user = user;
    }
}








//public User getUser() {
//    return user;
//}
//
//public Department getDepartment() {
//    return department;
//}
//
//public void setId(Long id) {
//    this.id = id;
//}
//
//public void setDepartment(Department department) {
//    this.department = department;
//}
//
//public void setSalary(double salary) {
//    this.salary = salary;
//}
//
//public void setName(String name) {
//    this.name = name;
//}
//
//public Long getId() {
//    return id;
//}
//
//
//public String getName() {
//    return name;
//}
//
//public double getSalary() {
//    return salary;
//}