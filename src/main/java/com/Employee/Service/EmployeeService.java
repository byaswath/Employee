package com.Employee.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Employee.Dao.EmployeeDao;
import com.Employee.Entity.Employee;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeDao ed;
	
	public List<Employee> getFemaleEmp() {
		return ed.getFemaleEmp();
	}
	
	public List<Employee> getThis(String a) {
		return ed.getThis(a);
	}
	
	public String postOneEmp(Employee e) {
		return ed.postOneEmp(e);
	}
	
	public String postAllEmp(List<Employee> e) {
		return ed.postAllEmp(e);
	}
	
	public Optional<Employee> getOneEmp(int a) {
		return ed.getOneEmp(a);
	}
	
	public List<Employee> getAllEmp() {
		return ed.getAllEmp();
	}
	
	public String deleteId(int b) {
		return ed.deleteId(b);
	}
	
	public String updateId(int c,Employee e) {
		return ed.updateId(c, e);
	}
	
	public List<Employee> findBySalaryGreaterThan(int salary) {
		return ed.findBySalaryGreaterThan(salary);
	}
	
	public List<Employee> findByNameStartingWith(String prefix) {
		return ed.findByNameStartingWith(prefix);
	}
	
	public Optional<Employee> findTopByOrderBySalaryDesc() {
		return ed.findTopByOrderBySalaryDesc();
	}
	
	public List<Employee> getFemale() {
		List<Employee> x = ed.getAllEmp();
		List<Employee> fList = x.stream().filter(y -> y.getGender().equals("Female")).collect(Collectors.toList());
		return fList;
	}
	
	public List<String> giveIdGetBrand(int f) {
		List<Employee> x = ed.getAllEmp();
		List<String> gBrand = x.stream().filter(y -> y.getId()== f).map(z -> z.getName()).collect(Collectors.toList());
		return gBrand;
	}
	
	public int getMaxSal() {
		List<Employee> x = ed.getAllEmp();
		int maximumSal = x.stream().map(y -> y.getSalary()).max(Comparable::compareTo).get();
		return maximumSal;
	}
	
	public int getMinSal() {
		List<Employee> x = ed.getAllEmp();
		int minimumSal = x.stream().map(y -> y.getSalary()).min(Comparable::compareTo).get();
		return minimumSal;
	}
	
	public List<Employee> getSalarySorted() {
        List<Employee> employees = ed.getAllEmp();
        List<Employee> sortedBySalaryDesc = employees.stream()
                .sorted(Comparator.comparingInt(Employee::getSalary).reversed())
                .collect(Collectors.toList());
        return sortedBySalaryDesc;
    }
	
	public List<Employee> getSalaryBetween(int g,int h) {
		List<Employee> x = ed.getAllEmp();
		List<Employee> salaryBetween = x.stream().filter(y -> y.getSalary()>g && y.getSalary()<h).collect(Collectors.toList());
		return salaryBetween;
	}
	
	public List<Employee> getMaxEmployeeDetail() {
		List<Employee> employees = ed.getAllEmp();
		List<Employee> maxDetail = employees.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).limit(1).collect(Collectors.toList());
		return maxDetail;
	}
	
	public Employee getMinSalaryWithBonus() {
		List<Employee> xx = ed.getAllEmp();
		Employee minSal = xx.stream().sorted(Comparator.comparing(Employee::getSalary)).findFirst().get();
		minSal.setSalary(minSal.getSalary()+(minSal.getSalary()*5/100));
		return minSal;
		
	}
	
	
}
