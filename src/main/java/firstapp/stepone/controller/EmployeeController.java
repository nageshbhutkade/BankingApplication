package firstapp.stepone.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import firstapp.stepone.Model.Employee;
import firstapp.stepone.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeservice;
	
	@GetMapping("/")
	public List<Employee> getAllEmployee() {
		return employeeservice.findAllEmployee();
	}
	
	@GetMapping("/employee/{id}")
	public Optional<Employee> getEmployee(@PathVariable int id) {
		Optional<Employee> employee = employeeservice.getEmployee(id);
		return employee;
	}
	
	@PostMapping("employee")
	public String postEmployee(@RequestBody Employee employee) {
		System.out.println(employee);
		return "Post param";
	}
}
