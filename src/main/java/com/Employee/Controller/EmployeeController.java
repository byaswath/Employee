package com.Employee.Controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Employee.Entity.Employee;
import com.Employee.Service.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	EmployeeService es;
	
	@GetMapping(value = "/getFemaleEmp")
	public List<Employee> getFemaleEmp() {
		return es.getFemaleEmp();
	}
	
	@GetMapping(value = "/getName/{a}")
	public List<Employee> getThis(@PathVariable String a) {
		return es.getThis(a);
	}
	
	
	@PostMapping(value = "/PostOneEmp")
	public String postOneEmp(@RequestBody Employee e) {
		return es.postOneEmp(e);
	}
	
	@PostMapping(value = "/postAllEmp")
	public String postAllEmp(@RequestBody List<Employee> e) {
		return es.postAllEmp(e);
	}
	
	@GetMapping(value = "/getOneEmp/{a}")
	public Optional<Employee> getOneEmp(@PathVariable int a) {
		return es.getOneEmp(a);
	}
	
	@GetMapping(value = "/getAllEmp")
	public List<Employee> getAllEmp() {
		return es.getAllEmp();
	}
	
	@DeleteMapping(value = "/deleteId/{b}")
	public String deleteId(@PathVariable int b) {
		return es.deleteId(b);
	}
	
	@PutMapping(value = "/updateId/{c}")
	public String updateId(@PathVariable int c,@RequestBody Employee e) {
		return es.updateId(c, e);
	}
	
	@GetMapping(value = "/salaryAbove4000/{salary}")
	public List<Employee> findBySalaryGreaterThan(@PathVariable int salary) {
		return es.findBySalaryGreaterThan(salary);
	}
	
	@GetMapping(value = "/nameStartsWith")
	public List<Employee> findByNameStartingWith(@RequestParam String prefix) {
		return es.findByNameStartingWith(prefix);
	}
	
	@GetMapping(value = "/maxSalary")
	public Optional<Employee> findTopByOrderBySalaryDesc() {
		return es.findTopByOrderBySalaryDesc();
	}
	
	@GetMapping(value = "/getAllFemaleList")
	public List<Employee> getFemale() {
		return es.getFemale();
	}
	
	@GetMapping(value = "/giveIdGetBrand/{f}")
	public List<String> giveIdGetBrand(@PathVariable int f) {
		return es.giveIdGetBrand(f);
		
	}
	
	@GetMapping(value = "/maximumSalary")
	public int getMaxSal() {
		return es.getMaxSal();
	}
	
	@GetMapping(value = "/minimumSalary")
	public int getMinSal() {
		return es.getMinSal();
	}
	
	@GetMapping(value = "/salDescending")
	public List<Employee> getSalarySorted() {
		return es.getSalarySorted();
	}
	
	@GetMapping(value ="/getSalBetween/{g}/{h}")
	public List<Employee> getSalaryBetween(@PathVariable int g,@PathVariable int h) {
		return es.getSalaryBetween(g, h);
	}
	@GetMapping(value = "/getMaxEmployeeDetail")
	public List<Employee> getMaxEmployeeDetail() {
		return es.getMaxEmployeeDetail();
	}
	@GetMapping(value = "/getMinSalaryWithSetBonus")
	public Employee getMinSalaryWithBonus() {
		return es.getMinSalaryWithBonus();
	}
	
	
	
}
