package com.example.New.demo.Model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Table(name = "user")
@Entity
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Employee employee;


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "role_id",joinColumns =@JoinColumn(name = "user_id"))
    Set<Role> roles = new HashSet<>();


    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
