package com.lab5.springboot.lab5.gl.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lab5.springboot.lab5.gl.Entity.Employee_Details;
import com.lab5.springboot.lab5.gl.Service.Employee_Service;

@Controller
@RequestMapping("/Employees")
public class EmployeeController {
	
	@Autowired
	Employee_Service employee_Service;
	

	
	/*@PostMapping("/new")
	public Employee_Details add_details(@RequestParam("emp_id")int emp_id ,
			@RequestParam("f_name") String f_name,
			@RequestParam("l_name") String l_name,
			@RequestParam("email")String email) {
		
		
		Employee_Details employee_Details1 =new Employee_Details();
		employee_Details1.setEmail(email);
		employee_Details1.setF_name(f_name);
		employee_Details1.setL_name(l_name);
		
		return employee_Service.add_details(employee_Details1);
	}*/
	
	@PostMapping("/addbyjson")
	public Employee_Details addEmp(@RequestBody Employee_Details emp1)
	{	
		return employee_Service.addEmp(emp1);	
	}	

	
	@GetMapping("/emp_detail")
	public Employee_Details get_details(@RequestParam("emp_id") int emp_id ) {
		
		
		return employee_Service.get_details(emp_id);
		
	}
	
	
	@GetMapping()
	public List<Employee_Details>  getAlldetail( ) {
		
		
		return employee_Service.getAlldetail();
		
	}
	
		
	@PutMapping("/edits")
	public Employee_Details update_details(@RequestParam("emp_id")int emp_id ,@RequestBody Employee_Details emp1){
		return employee_Service.update_details(emp_id , emp1);
		
	}
	
	
	@DeleteMapping("/deleteEmp")
	public String deleteEmp(@RequestParam("emp_id")int emp_id) {
		employee_Service.deleteEmp(emp_id);
		return "Employee info deleted";
	}
	
	//-----
	
	@GetMapping("/list")
	public String  listEmp(Model empModel ) {   //thymeleaf
		
		List <Employee_Details> listEmps =employee_Service.getAlldetail();
		empModel.addAttribute("employees", listEmps);
		return "company/list_employee";//page path
		
	}
	
	
	@GetMapping("/new")//correct
	public String showFormForAdd(Model empModel)
	{
		Employee_Details details=new Employee_Details();
		empModel.addAttribute("employees",details);
		return "company/employees-formNew";
	}
	@GetMapping("/edit")
	public String showFormForUpdate(@RequestParam("empId") int emps_id, //B.E->F.E
									Model empModel)
	{
		Employee_Details emp3=employee_Service.get_details(emps_id);
		empModel.addAttribute("employees",emp3);
		return "company/employeeEdit";
	}
	
	
	
	
	@PostMapping("/save")
	public String saveEmp(@ModelAttribute("employees") Employee_Details emp2)
	{
		employee_Service.addEmp(emp2);	
		return "redirect:/Employees/list";
	}
	
	
	/*@PostMapping("/edit")
	public String saveUpdate(@RequestParam("empId") int emps_id, //B.E->F.E
									Model empModel)
	{
		Employee_Details emp3=employee_Service.get_details(emps_id);
		empModel.addAttribute("employees",emp3);
		return "company/employeeEdit";
	}
	*/
	
	@GetMapping("/delete")
	public String deleteMyEmp(@RequestParam("emp_id") int emp_id)
	{
		employee_Service.deleteEmp(emp_id);
		return "redirect:/Employees/list";
	}
	
	
	
	
	
	
	
	

}
