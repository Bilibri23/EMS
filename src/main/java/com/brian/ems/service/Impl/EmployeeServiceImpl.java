package com.brian.ems.service.Impl;

import com.brian.ems.Mapper.EmployeeMapper;
import com.brian.ems.dto.EmployeeDto;
import com.brian.ems.exception.ResourceNotFoundException;
import com.brian.ems.model.Employee;
import com.brian.ems.repository.EmployeeRepository;
import com.brian.ems.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);
        //returning the savedEmployee back to the client
        EmployeeDto employeeDto1 = EmployeeMapper.mapToEmployeeDto(savedEmployee);

        return employeeDto1;
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeID) {
        Employee employee = employeeRepository.findById(employeeID).orElseThrow(()->new ResourceNotFoundException("This employee  with given id "+employeeID+ "  does not exist"));
        EmployeeDto employeeDto = EmployeeMapper.mapToEmployeeDto(employee);
        return employeeDto;
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
       List<Employee> employees = employeeRepository.findAll();

       return employees.stream().map(employee -> EmployeeMapper.mapToEmployeeDto(employee)).collect(Collectors.toList());
    }

    @Override
    public EmployeeDto UpdateEmployee(Long employeeID, EmployeeDto employeeDto) {

        Employee employee = employeeRepository.findById(employeeID).orElseThrow(
                () -> new ResourceNotFoundException("Employee not found with given id: " + employeeID)
        );

        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setEmail(employeeDto.getEmail());
        //  u have updated that particular employee  , now u saving it

        Employee updatedEmployee = employeeRepository.save(employee);
        //the save method performs  update and insert operations internally
        //if it contains the id its update, else it will insert
        return EmployeeMapper.mapToEmployeeDto(updatedEmployee);

    }

    @Override
    public void DeleteEmployee(Long EmployeeID) {
        //if the employee u want to delete does not exist
        employeeRepository.findById(EmployeeID).orElseThrow(
                () -> new ResourceNotFoundException("Employee not found with given id: " + EmployeeID)
        );

        employeeRepository.deleteById(EmployeeID);

    }
}
