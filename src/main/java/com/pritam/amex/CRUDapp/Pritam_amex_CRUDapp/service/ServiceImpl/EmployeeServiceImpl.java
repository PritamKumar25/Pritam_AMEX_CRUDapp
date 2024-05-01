package com.pritam.amex.CRUDapp.Pritam_amex_CRUDapp.service.ServiceImpl;

import com.pritam.amex.CRUDapp.Pritam_amex_CRUDapp.Dao.EmployeeDao;
import com.pritam.amex.CRUDapp.Pritam_amex_CRUDapp.Entity.Employee;
import com.pritam.amex.CRUDapp.Pritam_amex_CRUDapp.repository.EmployeeRepo;
import com.pritam.amex.CRUDapp.Pritam_amex_CRUDapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private EmployeeRepo employeeRepo;

    @Override
    public Employee createEmployee(Employee employee) {
        return employeeDao.createEmployeeDao(employee);
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeDao.getAllEmployeeDao();
    }

    @Override
    public Employee getEmployeeById(int empId) {
        return employeeDao.getEmployeeByIdDao(empId);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return employeeDao.updateEmployeeDao(employee);
    }

    @Override
    public Boolean deleteEmployee(int empId) {
        return employeeDao.deleteEmployeeDao(empId);
    }
}
