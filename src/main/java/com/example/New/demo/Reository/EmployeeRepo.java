package com.example.New.demo.Reository;

import com.example.New.demo.HRstaticsProjection;
import com.example.New.demo.Model.Employee;
//import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;


@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {
//    @Query("select name from employee")


    public List<Employee> findByName(String name);

    List<Employee> findByIdAndName(Long id, String name);

    //    @Query(value = "select emp from employee join Department dept on dept.id=emp.department_id")
    List<Employee> findByDepartmentId(Long deptid);

    List<Employee> findByDepartmentName(String deptname);


    List<Employee> findByNameContainingAndDepartmentNameContaining(String empname, String deptname);

    Long countByNameContainingAndDepartmentNameContaining(String empname, String deptname);

    @Modifying
    @Transactional
    Long deleteByNameContainingAndDepartmentNameContaining(String empname, String deptname);

    List<Employee> findBySalary(Double salary);

    List<Employee> findByDepartment(Long id);


    //this is native query..is name of the table is table vs jpql use table from name of the entity
    @Query(value = "select * from employee emp where emp.name like=:name", nativeQuery = true)
    List<Employee> filternative(String name);

    //jpql
    @Query(value = "select emp from Employee where emp.name like=:name", nativeQuery = true)
    List<Employee> filter(String name);


    @Query(value = "select\n" +
            "(select count(*) from employee) emp_count,\n" +
            "(select count(*) from department)dept_count,\n" +
            "(select count(*) from user) user_count", nativeQuery = true)
    HRstaticsProjection getHRStatics();

}
