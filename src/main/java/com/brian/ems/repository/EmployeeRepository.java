package com.brian.ems.repository;

import com.brian.ems.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;


// no need to annotate it bcs the simpleJpaRepository class which implements
// JpaRepository is annotated with it already
// @Repository, @Transactional, transactional on methods for database transactions, rolls back
//when an exception is found, commits when successful
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
