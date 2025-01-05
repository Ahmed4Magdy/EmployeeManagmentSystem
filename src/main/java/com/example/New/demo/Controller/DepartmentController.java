package com.example.New.demo.Controller;


import com.example.New.demo.Model.Department;
import com.example.New.demo.Model.Employee;
import com.example.New.demo.Service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

//    @GetMapping("/{id}")
//    public Department FindByid(@PathVariable Long id){
//
//        return departmentService.FindByid(id);
//    }


    @PostMapping("/post")
    public Department insert(@RequestBody Department dept) {
        return departmentService.insert(dept);
    }

    @PutMapping()
    public Department update(@RequestBody Department dept) {

        return departmentService.update(dept);
    }

    @GetMapping("")
    public List<Department> details() {
        return departmentService.details();
    }


//    @GetMapping("/{id}")
//    public Department FindByid(@PathVariable Long id) {
//        Department department = departmentService.FindByid(id);
//        department.getEmployes().size();  //       (lazy loading)
//        return department;
//    }



}
