package mk.springdemo.springbootrest2.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import mk.springdemo.springbootrest2.entity.Employee;

@Repository
public class EmployeeDAOJPAImpl implements EmployeeDAO {

	private EntityManager entityManager;
	
	@Autowired
	public EmployeeDAOJPAImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Override
	public List<Employee> findAll() {
		Query query = entityManager.createQuery("from Employee");
		
		List<Employee> employees = query.getResultList();
		return employees;
	}

	@Override
	public Employee findById(int id) {
		Employee employee = entityManager.find(Employee.class, id);
		return employee;
	}

	@Override
	public void save(Employee employee) {
		Employee savedEmp = entityManager.merge(employee);
		employee.setId(savedEmp.getId());
		
	}

	@Override
	public void deleteById(int id) {
		Employee employee = entityManager.find(Employee.class, id);
		entityManager.remove(employee);
	}

}
