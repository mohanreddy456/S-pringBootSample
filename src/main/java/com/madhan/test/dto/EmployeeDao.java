package com.madhan.test.dto;

import org.springframework.data.repository.CrudRepository;

import com.madhan.test.entity.Employee;

public interface EmployeeDao extends CrudRepository<Employee, Integer>
{

	Employee findByEno(Integer eno);


}












