package com.Employee.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Employee.Entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer>{

	List<Employee> findBySalaryGreaterThan(int salary);
	
	List<Employee> findByNameStartingWith(String prefix);
	
	Optional<Employee> findTopByOrderBySalaryDesc();
	
	@Query(value = "select * from emp where gender = 'Female';" , nativeQuery = true)
	public List<Employee> getFemaleEmp();
	
	@Query(value = "select * from emp where name like ?" , nativeQuery = true)
	public List<Employee> getThis(String a);
	
}

//flatmap
//anymatch
//summingInt
//max 
//min
//sorted-reverse order
//distinct
//Limit
//Second max
//filter-sort-
//age in-between-getemployee details
