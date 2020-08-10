package mk.springdemo.springbootrest2.dao;

import java.util.List;

import mk.springdemo.springbootrest2.entity.Employee;

public interface EmployeeDAO {

	public List<Employee> findAll();
	
	public Employee findById(int id);
	
	public void save(Employee employee);
	
	public void deleteById(int id);
}
