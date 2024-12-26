package com.example.New.demo.Reository;

import com.example.New.demo.Model.Employee;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepo extends CrudRepository<Employee, Long> {
//    @Query("select name from employee")
    List<Employee> findByName(String name);

    List<Employee> findByIdAndName(Long id,String name);

}
