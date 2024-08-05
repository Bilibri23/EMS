package com.brian.ems.service;

import com.brian.ems.dto.EmployeeDto;
import com.brian.ems.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);

    EmployeeDto getEmployeeById(Long employeeID);

    List<EmployeeDto> getAllEmployees();

    EmployeeDto UpdateEmployee(Long employeeID, EmployeeDto employeeDto);

    void DeleteEmployee(Long EmployeeID);
}
