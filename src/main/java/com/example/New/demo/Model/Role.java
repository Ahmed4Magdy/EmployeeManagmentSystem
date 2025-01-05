package com.example.New.demo.Model;


import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Table(name = "role")
@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    public void setId(Long id) {
        Id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public void setUsers(Set<User> users) {
//        this.users = users;
//    }

    private String name;

//    @ManyToMany(mappedBy = "roles")
//    Set<User> users = new HashSet<>();

    public Long getId() {
        return Id;
    }

    public String getName() {
        return name;
    }

//    public Set<User> getUsers() {
//        return users;
//    }
}
