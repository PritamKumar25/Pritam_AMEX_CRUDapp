package com.pritam.amex.CRUDapp.Pritam_amex_CRUDapp.Dao;

import com.pritam.amex.CRUDapp.Pritam_amex_CRUDapp.Entity.Employee;
import com.pritam.amex.CRUDapp.Pritam_amex_CRUDapp.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class EmployeeDao {

    @Autowired
    private EmployeeRepo employeeRepo;

    public Employee createEmployeeDao(Employee employee){
        return employeeRepo.save(employee);
    }

    public List<Employee> getAllEmployeeDao(){
        return employeeRepo.findAll();
    }

    public Employee getEmployeeByIdDao(int EmpId){
        return employeeRepo.findById(EmpId).get();
    }

    public Employee updateEmployeeDao(Employee employee){
        Optional<Employee> employeeById = employeeRepo.findById(employee.getEmpId());
        Employee employee1 = new Employee();
        if(employeeById.isPresent()){
            employee1 = employeeById.get();
            employee1.setEmpName(employee.getEmpName());
            employee1.setEmpDept(employee.getEmpDept());
            employee1.setEmpSalary(employee.getEmpSalary());
            employee1.setEmpDesignation(employee.getEmpDesignation());
            return employeeRepo.save(employee1);
        }
        else{
            return employee1;
        }

    }

    public Boolean deleteEmployeeDao(int empId){
        employeeRepo.deleteById(empId);
        return true;
    }


}
