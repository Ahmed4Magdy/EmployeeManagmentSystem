package com.example.New.demo.Reository;

import com.example.New.demo.HRstaticsProjection;
import com.example.New.demo.Model.Employee;
//import org.springframework.data.jdbc.repository.query.Query;
import com.example.New.demo.Projection.EmployeeProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;


@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {
//    @Query("select name from employee")


    public List<Employee> findByFirstname(String name);

    List<Employee> findByIdAndFirstname(Long id, String name);

    //    @Query(value = "select emp from employee join Department dept on dept.id=emp.department_id")
    List<Employee> findByDepartmentId(Long deptid);

    List<Employee> findByDepartmentName(String deptname);


    List<Employee> findByFirstnameContainingAndDepartmentNameContaining(String empname, String deptname);

    Long countByFirstnameContainingAndDepartmentNameContaining(String empname, String deptname);

    @Modifying
    @Transactional
    Long deleteByFirstnameContainingAndDepartmentNameContaining(String empname, String deptname);

//    List<Employee> findBySalary(Double salary);

//    List<Employee> findByDepartmentId(Long deptid);


    //this is native query..is name of the table is table vs jpql use table from name of the entity
    @Query(value = "select * from employee emp where emp.first_name like %:first_name%", nativeQuery = true)
    List<Employee> filternative(@Param("first_name") String first_name);

    //jpql
    //#{#entityName}
    @Query("select emp from Employee emp where(:first_name is null or emp.firstname like %:first_name%)")
    Page<EmployeeProjection> filter(@Param("first_name") String first_name, Pageable pageable);

//    @Query("select new Employee(emp.id,emp.firstname,emp.lastname) from Employee emp where(:first_name is null or emp.firstname like %:first_name%)")
//    Page<Employee> filter(@Param("first_name") String first_name, Pageable pageable);


    @Query(value = "select\n" +
            "(select count(*) from employee) emp_count,\n" +
            "(select count(*) from department)dept_count,\n" +
            "(select count(*) from user) user_count", nativeQuery = true)
    HRstaticsProjection getHRStatics();

}
