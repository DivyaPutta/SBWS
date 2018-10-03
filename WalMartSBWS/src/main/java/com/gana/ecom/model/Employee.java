package com.gana.ecom.model;

import java.util.Date;

public class Employee {

	private int employeeId;
	private Date employeeDob;
	private String employeeName;
	private String employeeAddress;
	private String employeeEmail;
	public int getEmployeeId() {
		return employeeId;
	}
	public Date getEmployeeDob() {
		return employeeDob;
	}
	public void setEmployeeDob(Date employeeDob) {
		this.employeeDob = employeeDob;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmployeeAddress() {
		return employeeAddress;
	}
	public void setEmployeeAddress(String employeeAddress) {
		this.employeeAddress = employeeAddress;
	}
	public String getEmployeeEmail() {
		return employeeEmail;
	}
	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	
}
