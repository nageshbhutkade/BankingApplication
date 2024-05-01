package firstapp.stepone.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import firstapp.stepone.Model.Employee;
import firstapp.stepone.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository employeerepository;
	
	public List<Employee> findAllEmployee(){
		return employeerepository.findAll();
	}

	public Optional<Employee> getEmployee(int id) {
		// TODO Auto-generated method stub
		return employeerepository.findById(id);
	}
	
}
