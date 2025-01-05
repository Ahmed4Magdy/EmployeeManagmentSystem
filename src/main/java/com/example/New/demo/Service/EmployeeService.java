package com.example.New.demo.Service;

import com.example.New.demo.HRstaticsProjection;
import com.example.New.demo.Model.Department;
import com.example.New.demo.Model.Employee;
import com.example.New.demo.Reository.EmployeeRepo;
import com.example.New.demo.Reository.UserReo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

//    @Autowired
//    private UserReo userReo;


    public Iterable<Employee> findetails() {
        return employeeRepo.findAll();

    }

    public Employee insert(Employee emp) {
        return employeeRepo.save(emp);
    }


    public Employee update(Employee emp) {

        Employee current = employeeRepo.findById(emp.getId()).orElseThrow();
        current.setName(emp.getName());
        current.setSalary(emp.getSalary());
        current.setDepartment(emp.getDepartment());
        return employeeRepo.save(current);
    }

    public void Delete(Long id) {

        employeeRepo.deleteById(id);
    }

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


    public Employee FindId(Long id) {
        //modify status
        return employeeRepo.findById(id).get();
        //insteadof return obj..we return responseentity
        //correct ..first way
        //return  new ResponseEntity(employeeRepo.findById(id).get(), HttpStatus.OK);
        // second way
        //return ResponseEntity.ok(employeeRepo.findById(id));
    }


    public List<Employee> findByDepartmentId(Long deptid) {

        return employeeRepo.findByDepartmentId(deptid);

    }


    public List<Employee> findByDepartmentName(String deptname) {

        return employeeRepo.findByDepartmentName(deptname);

    }

    public List<Employee> findByNameAndDepartment(String empname, String deptname) {

        return employeeRepo.findByNameContainingAndDepartmentNameContaining(empname, deptname);
    }

    public Long countNameAndDepartmentName(String empname, String deptname) {

        return employeeRepo.countByNameContainingAndDepartmentNameContaining(empname, deptname);

    }

@Transactional
    public Long deleteByNameContainingAndDepartmentNameContaining(String empname, String deptname) {

        return employeeRepo.deleteByNameContainingAndDepartmentNameContaining(empname, deptname);
    }


    public List<Employee> findBySalary(Double salary){

        return employeeRepo.findBySalary(salary);
    }

   public  List<Employee> findByDepartment(Long id){
        return employeeRepo.findByDepartment(id);
    }


  public  HRstaticsProjection getHRStatics(){
        return employeeRepo.getHRStatics();
  }



}
