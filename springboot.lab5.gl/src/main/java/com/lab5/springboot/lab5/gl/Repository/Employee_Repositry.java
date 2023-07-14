package com.lab5.springboot.lab5.gl.Repository;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.lab5.springboot.lab5.gl.Entity.Employee_Details;

public interface Employee_Repositry extends JpaRepositoryImplementation<Employee_Details, Integer> {

	Employee_Details save(Employee_Details employee_Details1);

}
