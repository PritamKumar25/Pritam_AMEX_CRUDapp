package com.pritam.amex.CRUDapp.Pritam_amex_CRUDapp.ResponsePayload;

import com.pritam.amex.CRUDapp.Pritam_amex_CRUDapp.Dao.EmployeeDao;
import com.pritam.amex.CRUDapp.Pritam_amex_CRUDapp.Entity.Employee;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeResponsePayload {

    private String message;

    private List<Employee> employee;
}
