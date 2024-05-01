package com.pritam.amex.CRUDapp.Pritam_amex_CRUDapp.service;

import com.pritam.amex.CRUDapp.Pritam_amex_CRUDapp.Entity.Employee;

import java.util.List;


public interface EmployeeService {

    public Employee createEmployee(Employee employee);

    public List<Employee> getAllEmployee();

    public Employee getEmployeeById(int empId);

    public Employee updateEmployee(Employee employee);

    public Boolean deleteEmployee(int empId);
}
