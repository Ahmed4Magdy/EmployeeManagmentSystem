package com.example.New.demo.Service;

import com.example.New.demo.Model.Department;
import com.example.New.demo.Model.Employee;
import com.example.New.demo.Reository.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepo departmentRepo;


    public Department FindByid(Long id) {

        return departmentRepo.findById(id).orElseThrow();
    }


    public Department insert(Department dept) {
        return departmentRepo.save(dept);
    }


    public Department update(Department dept) {

        Department current = departmentRepo.findById(dept.getId()).orElseThrow();
        current.setName(dept.getName());
        return departmentRepo.save(current);
    }


    public List<Department> details() {
        return departmentRepo.findAll();
    }





}