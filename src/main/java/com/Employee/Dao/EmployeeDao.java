package com.Employee.Dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Employee.Entity.Employee;
import com.Employee.Repository.EmployeeRepository;

@Repository
public class EmployeeDao {
	
	@Autowired
	EmployeeRepository er;
	
	public List<Employee> getFemaleEmp() {
		return er.getFemaleEmp();
	}
	
	public List<Employee> getThis(String a) {
		return er.getThis(a);
	}

		
	
	public String postOneEmp(Employee e) {
		er.save(e);
		return "Posted Successfully";
	}
	
	public String postAllEmp(List<Employee> e) {
		er.saveAll(e);
		return "All Posted Successfully";
	}
	
	public Optional<Employee> getOneEmp(int a) {
		return er.findById(a);
	}
	
	public List<Employee> getAllEmp() {
		return er.findAll();
	}
	
	public String deleteId(int b) {
		er.deleteById(b);
		return "Deleted the given Id Successfully";
	}
	
	public String updateId(int c,Employee e) {
		er.save(e);
		return "Updated Successfully";
	}
	
	public List<Employee> findBySalaryGreaterThan(int salary) {
		return er.findBySalaryGreaterThan(salary);
	}
	
	public List<Employee> findByNameStartingWith(String prefix) {
		return er.findByNameStartingWith(prefix);
	}
	
	public Optional<Employee> findTopByOrderBySalaryDesc() {
		return er.findTopByOrderBySalaryDesc();
	}
	
	
	

}
