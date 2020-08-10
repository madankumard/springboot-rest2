package mk.springdemo.springbootrest2.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import mk.springdemo.springbootrest2.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
}
