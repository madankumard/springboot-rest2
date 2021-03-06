package mk.springdemo.springbootrest2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mk.springdemo.springbootrest2.dao.EmployeeRepository;
import mk.springdemo.springbootrest2.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	//@Autowired
	//@Qualifier("employeeDAOJPAImpl")
	//private EmployeeDAO employeeDAO;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	@Transactional
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	@Override
	@Transactional
	public Employee findById(int id) {
		Optional<Employee> employeeOptional = employeeRepository.findById(id);
		return employeeOptional.orElse(null);
	}

	@Override
	@Transactional
	public void save(Employee employee) {
		employeeRepository.save(employee);
	}

	@Override
	@Transactional
	public void deleteById(int id) {
		employeeRepository.deleteById(id);
	}

}
