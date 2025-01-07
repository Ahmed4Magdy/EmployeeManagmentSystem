package com.example.New.demo.Projection;

import org.springframework.beans.factory.annotation.Value;

import java.lang.annotation.Target;

//close projection ..is same properties that in entity equal that in interface here ...i used interface because use special properities for use
public interface EmployeeProjection {

    Long getId();

    String getfirstname();

    String getlastname();


    //open projection..means that if has property such as getfullname is not map in entity ..we use for properties firstname and lastname from entity for map

    @Value("#{target.firstname+''+target.lastname}")
    String getFullName();


}
