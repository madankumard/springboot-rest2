package mk.springdemo.springbootrest2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mk.springdemo.springbootrest2.entity.Employee;
import mk.springdemo.springbootrest2.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/employees")
	public List<Employee> listEmployees(){
		List<Employee> employees = employeeService.findAll();
		return employees;
	}
	
	@GetMapping("/employees/{id}")
	public Employee getEmployee(@PathVariable("id") int id) {
		Employee employee = employeeService.findById(id);
		if(employee == null) {
			throw new RuntimeException("Employee Not Found id: "+ id);
		}
		return employee;
	}
	
	@PostMapping("/employees")
	public Employee saveEmployee(@RequestBody Employee employee) {
		employee.setId(0);
		employeeService.save(employee);
		return employee;
	}
	
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee employee) {
		employeeService.save(employee);
		return employee;
	}
	
	@DeleteMapping("/employees/{id}")
	public String deleteEmployee(@PathVariable("id") int id) {
		Employee employee = employeeService.findById(id);
		if(employee == null) {
			throw new RuntimeException("Employee Not Found id: "+ id);
		}
		employeeService.deleteById(id);
		return "Deleted employee : "+ id;
	}
}
