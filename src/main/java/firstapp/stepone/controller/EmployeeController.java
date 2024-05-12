package firstapp.stepone.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import firstapp.stepone.Model.Employee;
import firstapp.stepone.service.EmployeeService;

@RestController
public class EmployeeController {
	
	Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
	EmployeeService employeeservice;
	
	@GetMapping("/")
	public List<Employee> getAllEmployee() {
		logger.trace("Log level: TRACE"); 
        logger.info("Log level: INFO"); 
        logger.debug("Log level: DEBUG"); 
        logger.error("Log level: ERROR"); 
        logger.warn("Log level: WARN"); 
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
