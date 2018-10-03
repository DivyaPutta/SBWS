package com.gana.ecom.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gana.ecom.model.Employee;
@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
	@Autowired
	private DataSource dataSource;
	public void addEmployee(Employee employee) {
		try {
			PreparedStatement preparedStatement = dataSource.getConnection()
					.prepareStatement("insert into Employees(EmployeeName,EmployeeDob,EmployeeAddress,EmployeeEmail) values (?, ?, ?,? )");
			// Parameters start with 1
			preparedStatement.setString(1, employee.getEmployeeName());
			preparedStatement.setDate(2,new Date(Calendar.getInstance().getTimeInMillis()));
			preparedStatement.setString(3, employee.getEmployeeAddress());
			preparedStatement.setString(4, employee.getEmployeeEmail());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Employee> getAllEmployees() {
		List<Employee> Employees = new ArrayList<Employee>();
		try {
			Statement statement =  dataSource.getConnection().createStatement();
			ResultSet rs = statement.executeQuery("select * from Employees");
			while (rs.next()) {
				Employee Employee = new Employee();
				Employee.setEmployeeId(rs.getInt("EmployeeId"));
				Employee.setEmployeeName(rs.getString("EmployeeName"));
				Employee.setEmployeeDob(rs.getDate("EmployeeDob"));
				Employee.setEmployeeAddress(rs.getString("EmployeeAddress"));
				Employee.setEmployeeEmail(rs.getString("EmployeeEmail"));
				Employees.add(Employee);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return Employees;
	}

	@Override
	public void deleteEmployee(Integer employeeId) {
		try {
			PreparedStatement preparedStatement = dataSource.getConnection()
					.prepareStatement("delete from Employees where EmployeeId=?");
			// Parameters start with 1
			preparedStatement.setInt(1, employeeId);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Employee getEmployee(int empid) {
		Employee employee = new Employee();
		try {
			PreparedStatement preparedStatement = dataSource.getConnection().
					prepareStatement("select * from Employees where Employeeid=?");
			preparedStatement.setInt(1, empid);
			ResultSet rs = preparedStatement.executeQuery();
			
			if (rs.next()) {
				employee.setEmployeeId(rs.getInt("EmployeeId"));
				employee.setEmployeeName(rs.getString("EmployeeName"));
				employee.setEmployeeDob(rs.getDate("EmployeeDob"));
				employee.setEmployeeEmail(rs.getString("EmployeeEmail"));
				employee.setEmployeeAddress(rs.getString("EmployeeAddress"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return employee;
	}

	@Override
	public void updateEmployee(Employee employee) {
		try {
			PreparedStatement preparedStatement = dataSource.getConnection()
					.prepareStatement("update Employees set EmployeeName=?, EmployeeDob=?, EmployeeAddress=? " +
							 "where EmployeeId=?");
			// Parameters start with 1
			preparedStatement.setString(1, employee.getEmployeeName());
			preparedStatement.setDate(2,new Date(Calendar.getInstance().getTimeInMillis()));
			preparedStatement.setString(3, employee.getEmployeeAddress());
			preparedStatement.setInt(4, employee.getEmployeeId());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	

}