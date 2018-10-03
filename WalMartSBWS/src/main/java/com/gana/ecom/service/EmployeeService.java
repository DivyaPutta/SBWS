package com.gana.ecom.service;

import java.util.List;

import com.gana.ecom.model.Employee;

public interface EmployeeService {
	
	public void addEmployee(Employee employee);

	public List<Employee> getAllEmployees();

	public void deleteEmployee(Integer employeeId);

	public Employee getEmployee(int employeeid);

	public void updateEmployee(Employee employee);
}
