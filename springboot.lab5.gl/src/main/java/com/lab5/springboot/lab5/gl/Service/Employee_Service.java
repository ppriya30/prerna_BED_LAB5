package com.lab5.springboot.lab5.gl.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lab5.springboot.lab5.gl.Entity.Employee_Details;
import com.lab5.springboot.lab5.gl.Repository.Employee_Repositry;


@Service
public class Employee_Service {
	
	
	@Autowired
	Employee_Repositry employee_Repositry ;

	/*public Employee_Details add_details(Employee_Details employee_Details1) {
		
		
		
		return employee_Repositry.save(employee_Details1);
	}*/
	
	
	

	public Employee_Details get_details(int emp_id) {//get
		
		return employee_Repositry.findById(emp_id).get();
	}
	
	
	public List<Employee_Details> getAlldetail() { //get
		return employee_Repositry.findAll();
	}
	
	

	public Employee_Details update_details(int emp_id, Employee_Details emp1) { //put
		Employee_Details dbemp= get_details(emp_id);
		dbemp.setEmail(emp1.getEmail());
		dbemp.setF_name(emp1.getF_name());
		dbemp.setL_name(emp1.getL_name());
		return employee_Repositry.save(dbemp);
	}



	public void deleteEmp(int emp_id) {//delete
		employee_Repositry.deleteById(emp_id);
		
	}

	
	
	public Employee_Details addEmp(Employee_Details emp1) {//post
		
		return employee_Repositry.save(emp1);
	}

	

	}


