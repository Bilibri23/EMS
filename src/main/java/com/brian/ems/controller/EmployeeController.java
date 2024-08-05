package com.brian.ems.controller;

import com.brian.ems.dto.EmployeeDto;
import com.brian.ems.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/employees")
@CrossOrigin(origins = "https://employee-app-603a0098e877.herokuapp.com/")
public class EmployeeController {
    private final EmployeeService employeeService;

    @PostMapping()
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
       EmployeeDto savedEmployee =  employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee,HttpStatus.CREATED);
    }

    @GetMapping("{employeeID}")
    public ResponseEntity<EmployeeDto> getEmployeeByID(@PathVariable Long employeeID){
        EmployeeDto givenEmployee =  employeeService.getEmployeeById(employeeID);
        return  ResponseEntity.ok(givenEmployee);
    }

    @GetMapping()
    public ResponseEntity<List<EmployeeDto>> getAllEmployees(){
        List<EmployeeDto> employeeDtos = employeeService.getAllEmployees();
        return  ResponseEntity.ok(employeeDtos);
    }

    @PutMapping("{id}")
    public ResponseEntity<EmployeeDto> UpdateEmployee(@PathVariable("id") Long EmployeeID, @RequestBody EmployeeDto updatedEmployeeInfo){
        EmployeeDto updatedEmployee = employeeService.UpdateEmployee(EmployeeID,updatedEmployeeInfo);
        return ResponseEntity.ok(updatedEmployee);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> DeleteEmployee(@PathVariable("id")Long EmployeeID){
        employeeService.DeleteEmployee(EmployeeID);
        return  ResponseEntity.ok("Deleted successfully");

    }

}
