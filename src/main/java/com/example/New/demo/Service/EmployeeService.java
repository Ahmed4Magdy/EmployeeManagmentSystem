package com.example.New.demo.Service;

import com.example.New.demo.Model.Employee;
import com.example.New.demo.Reository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;


    public Iterable<Employee> findetails() {
        return employeeRepo.findAll();

    }

    public Employee insert(Employee emp) {
        return employeeRepo.save(emp);
    }

    public Employee update(Employee emp) {
        return employeeRepo.save(emp);
    }

    public void Delete(Long id) {

        employeeRepo.deleteById(id);
    }

    @GetMapping("/count")
//    @RequestMapping(method = RequestMethod.GET ,path = "/count")
    public Long Count() {
        return employeeRepo.count();
    }

    public List<Employee> findByName(String name) {
        return employeeRepo.findByName(name);
    }

    public List<Employee> findByIdAndName(Long id, String name) {
        return employeeRepo.findByIdAndName(id, name);
    }


    public Employee FindId(@PathVariable Long id) {
        //modify status
         return  employeeRepo.findById(id).get();
        //insteadof return obj..we return responseentity
        //correct ..first way
        //return  new ResponseEntity(employeeRepo.findById(id).get(), HttpStatus.OK);
        // second way
        //return ResponseEntity.ok(employeeRepo.findById(id));
    }
}
