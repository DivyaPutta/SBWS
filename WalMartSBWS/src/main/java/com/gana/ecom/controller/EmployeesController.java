package com.gana.ecom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gana.ecom.model.Employee;
import com.gana.ecom.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeesController {

    private EmployeeService employeeService;

    @Autowired
    public void setProductService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping(value = "/list", method= RequestMethod.GET, produces = "application/json")
    public Iterable<Employee> list(Model model){
        Iterable<Employee> productList = employeeService.getAllEmployees();
        return productList;
    }
    @RequestMapping(value = "/show", method= RequestMethod.GET, produces = "application/json")
    public Employee showProduct(@RequestParam Integer id, Model model){
       Employee product = employeeService.getEmployee(id);
        return product;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<String> saveProduct(@RequestBody Employee employee){
        employeeService.addEmployee(employee);
        return new ResponseEntity("Employee saved successfully", HttpStatus.OK);
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT, produces = "application/json")
    public ResponseEntity updateProduct(@PathVariable Integer id, @RequestBody Employee employee){
        Employee storedEmployee = employeeService.getEmployee(id);
        storedEmployee.setEmployeeName(employee.getEmployeeName());
        storedEmployee.setEmployeeAddress(employee.getEmployeeAddress());
        storedEmployee.setEmployeeEmail(employee.getEmployeeEmail());
        employeeService.addEmployee(storedEmployee);
        return new ResponseEntity("Employee updated successfully", HttpStatus.OK);
    }

    @RequestMapping(value="/delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public ResponseEntity delete(@PathVariable Integer id){
        employeeService.deleteEmployee(id);
        return new ResponseEntity("Employee deleted successfully", HttpStatus.OK);

    }

}
