package com.example.New.demo.Service;

import com.example.New.demo.HRstaticsProjection;
import com.example.New.demo.Model.Department;
import com.example.New.demo.Model.Employee;
import com.example.New.demo.Projection.EmployeeProjection;
import com.example.New.demo.Reository.EmployeeRepo;
import com.example.New.demo.Reository.UserReo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.transaction.Transactional;
import java.util.Collections;
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
        current.setFirstname(emp.getFirstname());
        current.setLastname(emp.getLastname());
        current.setLast_update(emp.getLast_update());
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
        return employeeRepo.findByFirstname(name);
    }

    public List<Employee> findByIdAndName(Long id, String name) {
        return employeeRepo.findByIdAndFirstname(id, name);
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

        return employeeRepo.findByFirstnameContainingAndDepartmentNameContaining(empname, deptname);
    }

    public Long countNameAndDepartmentName(String empname, String deptname) {

        return employeeRepo.countByFirstnameContainingAndDepartmentNameContaining(empname, deptname);

    }

    @Transactional
    public Long deleteByNameContainingAndDepartmentNameContaining(String empname, String deptname) {

        return employeeRepo.deleteByFirstnameContainingAndDepartmentNameContaining(empname, deptname);
    }


//    public List<Employee> findBySalary(Double salary){
//
//        return employeeRepo.findBySalary(salary);
//    }

//   public  List<Employee> findByDepartment(Long id){
//        return employeeRepo.findByDepartment(id);
//    }


    public HRstaticsProjection getHRStatics() {
        return employeeRepo.getHRStatics();
    }


    public Page<EmployeeProjection> filter(@Param("first_name") String first_name, int pagenum, int pagesize, Boolean isAsc, String sortcol) {
        if (first_name == null || first_name.isEmpty() || first_name.isBlank()) {
//            return Collections.emptyList();
            first_name = null;
        }

        Pageable page = PageRequest.of(pagenum,pagesize,isAsc? Sort.Direction.ASC: Sort.Direction.DESC,sortcol);
        return employeeRepo.filter(first_name,page);


    }


}
