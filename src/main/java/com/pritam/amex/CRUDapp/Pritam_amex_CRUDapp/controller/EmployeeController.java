package com.pritam.amex.CRUDapp.Pritam_amex_CRUDapp.controller;


import com.pritam.amex.CRUDapp.Pritam_amex_CRUDapp.Entity.Employee;
import com.pritam.amex.CRUDapp.Pritam_amex_CRUDapp.ResponsePayload.EmployeeResponsePayload;
import com.pritam.amex.CRUDapp.Pritam_amex_CRUDapp.service.ServiceImpl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/Employee")
public class EmployeeController {

    @Autowired
    private EmployeeServiceImpl employeeService;

    @PostMapping("/createEmployee")
    public ResponseEntity<?> createEmployee(@RequestBody Employee employee){
        EmployeeResponsePayload employeeResponsePayload = new EmployeeResponsePayload();
        Employee employee1 = employeeService.createEmployee(employee);
        List<Employee> employees = new ArrayList<>();

        if(employee1 != null){
            employeeResponsePayload.setMessage("Employee created successfully");
            employees.add(employee1);
            employeeResponsePayload.setEmployee(employees);
            return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(employeeResponsePayload);
        }

        else{
            employeeResponsePayload.setMessage("Employee not created.");
            return ResponseEntity.status(HttpStatusCode.valueOf(500)).body(employeeResponsePayload);
        }
    }

    @GetMapping("/getAllEmployee")
    public ResponseEntity<?> getAllEmployee(){
        EmployeeResponsePayload employeeResponsePayload = new EmployeeResponsePayload();
        List<Employee> employee1 = new ArrayList<>();
        employee1 = employeeService.getAllEmployee();

        if(!employee1.isEmpty()){
            employeeResponsePayload.setMessage("All Employees fetched successfully");
            employeeResponsePayload.setEmployee(employee1);
            return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(employeeResponsePayload);
        }

        else{
            employeeResponsePayload.setMessage("Employees not fetched.");
            employeeResponsePayload.setEmployee(employee1);
            return ResponseEntity.status(HttpStatusCode.valueOf(404)).body(employeeResponsePayload);
        }
    }

    @GetMapping("/getEmployeeById/{empId}")
    public ResponseEntity<?> getEmployeeById(@PathVariable int empId){
        EmployeeResponsePayload employeeResponsePayload = new EmployeeResponsePayload();
        List<Employee> employeeList = new ArrayList<>();
        Employee employee1 = employeeService.getEmployeeById(empId);

        if(employee1 != null){
            employeeResponsePayload.setMessage("Employee fetched successfully");
            employeeList.add(employee1);
            employeeResponsePayload.setEmployee(employeeList);
            return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(employeeResponsePayload);
        }

        else{
            employeeResponsePayload.setMessage("Employee not found with given Id.");
            employeeResponsePayload.setEmployee(employeeList);
            return ResponseEntity.status(HttpStatusCode.valueOf(404)).body(employeeResponsePayload);
        }
    }

    @PutMapping("/updateEmployee")
    public ResponseEntity<?> updateEmployee(@RequestBody Employee employee){
        EmployeeResponsePayload employeeResponsePayload = new EmployeeResponsePayload();
        Employee employee1 = employeeService.updateEmployee(employee);
        List<Employee> employeeList = new ArrayList<>();
        if(employee1 != null){
            employeeResponsePayload.setMessage("Employee updated successfully");
            employeeList.add(employee1);
            employeeResponsePayload.setEmployee(employeeList);
            return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(employeeResponsePayload);
        }

        else{
            employeeResponsePayload.setMessage("Employees not updated");
            employeeResponsePayload.setEmployee(employeeList);
            return ResponseEntity.status(HttpStatusCode.valueOf(304)).body(employeeResponsePayload);
        }
    }

    @DeleteMapping("/deleteEmployee/{empId}")
    public ResponseEntity<?> deleteEmployee(@PathVariable int empId){
        EmployeeResponsePayload employeeResponsePayload = new EmployeeResponsePayload();
        Boolean employeeDeleted = false;
        employeeDeleted = employeeService.deleteEmployee(empId);
        List<Employee> employeeList = new ArrayList<>();
        if(employeeDeleted){
            employeeResponsePayload.setMessage("Employee deleted successfully");
            employeeResponsePayload.setEmployee(employeeList);
            return ResponseEntity.status(HttpStatusCode.valueOf(204)).body(employeeResponsePayload);
        }

        else{
            employeeResponsePayload.setMessage("Employee not deleted");
            employeeResponsePayload.setEmployee(employeeList);
            return ResponseEntity.status(HttpStatusCode.valueOf(500)).body(employeeResponsePayload);
        }
    }
}
