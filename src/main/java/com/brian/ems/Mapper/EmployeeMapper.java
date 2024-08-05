package com.brian.ems.Mapper;

import com.brian.ems.dto.EmployeeDto;
import com.brian.ems.model.Employee;

public class EmployeeMapper {
    public static EmployeeDto mapToEmployeeDto(Employee employee){
        return new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail()
        );
    }

    public static Employee mapToEmployee(EmployeeDto employeeDto){
        return new Employee(employeeDto.getId(),employeeDto.getFirstName(), employeeDto.getLastName(),employeeDto.getEmail());
    }


    //Dto are design patterns that encapsulates the responses between the client and the server
    //such that data passed between the different services are not leaked,
    // when saving in the database u save an entity no a dto, when u get from the database
    //to present to the client u will not want to show personal details to client
}
