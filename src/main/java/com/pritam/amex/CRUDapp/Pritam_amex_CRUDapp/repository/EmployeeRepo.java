package com.pritam.amex.CRUDapp.Pritam_amex_CRUDapp.repository;

import com.pritam.amex.CRUDapp.Pritam_amex_CRUDapp.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
}
