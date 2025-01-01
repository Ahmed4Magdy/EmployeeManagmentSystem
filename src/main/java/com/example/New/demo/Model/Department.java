package com.example.New.demo.Model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="department")
public class Department {

    public List<Employee> getEmployes() {
        return employes;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

//    , cascade = CascadeType.ALL, fetch = FetchType.EAGER

    @OneToMany(mappedBy = "department")
    private List<Employee> employes;

    public void setId(Long id) {
        this.id = id;
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
}
