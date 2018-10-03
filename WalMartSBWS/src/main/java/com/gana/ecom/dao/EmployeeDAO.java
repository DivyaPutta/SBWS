package com.gana.ecom.dao;

import java.util.List;

import com.gana.ecom.model.Employee;

public interface EmployeeDAO {

	public void addEmployee(Employee employee);

	public List<Employee> getAllEmployees();

	public void deleteEmployee(Integer employeeId);

	public void updateEmployee(Employee employee);

	public Employee getEmployee(int employeeid);
}
