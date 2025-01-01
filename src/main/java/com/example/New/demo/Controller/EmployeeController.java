package com.example.New.demo.Controller;


import com.example.New.demo.Model.Department;
import com.example.New.demo.Model.Employee;
import com.example.New.demo.Reository.EmployeeRepo;
import com.example.New.demo.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {


    @Autowired
    private EmployeeService employeeService;


    @GetMapping("/count")
//    @RequestMapping(method = RequestMethod.GET ,path = "/count")
    public Long Empcount() {
        return employeeService.Count();
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> FindId(@PathVariable Long id) {
        //modify status
        // return  employeeRepo.findById(id)
        //insteadof return obj..we return responseentity
        //correct ..first way
        //return  new ResponseEntity(employeeRepo.findById(id).get(), HttpStatus.OK);
        // second way
        return ResponseEntity.ok(employeeService.FindId(id));
    }


    @GetMapping("")
    public Iterable<Employee> findetails() {
        return employeeService.findetails();

    }


    @GetMapping("/filter/")
    public List<Employee> findnameandid(@RequestParam Long id, @RequestParam String name) {

        return employeeService.findByIdAndName(id, name);
    }


    @PostMapping("/post")
    public Long insert(@RequestBody Employee emp) {
        Employee inserted= employeeService.insert(emp);
        return inserted.getId();
    }


    @PutMapping("")
    public Employee update(@RequestBody Employee emp) {
        return employeeService.update(emp);
    }


    @DeleteMapping("{id}")
    public void Delete(@PathVariable Long id) {

        employeeService.Delete(id);
    }


    @GetMapping("/department/{deptid}")
    public List<Employee> findByDepartment(@PathVariable Long deptid){
        return employeeService.findByDepartmentId(deptid);
    }


  @GetMapping("/department/name/{deptname}")
    public List<Employee> findByDepartmentName(@PathVariable String deptname){

        return employeeService.findByDepartmentName(deptname);

    }





}
