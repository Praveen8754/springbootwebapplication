package com.example.demo;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface EmployeeRecords extends CrudRepository<Employee,Integer> {
@Transactional
@Modifying
@Query("update Employee emp set emp.name=?1 where emp.empId=?2")
void setEmployeeById(String name,int empId);
}
