package com.example.New.demo.Reository;

import com.example.New.demo.Model.Employee;
//import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {
//    @Query("select name from employee")
    List<Employee> findByName(String name);
    List<Employee> findByIdAndName(Long id,String name);


//    @Query(value = "select emp from employee join Department dept on dept.id=emp.department_id")
    List<Employee> findByDepartmentId(Long deptid);



}
