package com.madhan.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.madhan.test.dto.EmployeeDao;
import com.madhan.test.entity.Employee;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeDao employeeRepository;

	@RequestMapping("/madhan")
	public Employee createEmployee() {
		Employee employee = new Employee();
		employee.setEno(755);
		employee.setEname("upendra");
		employee.setEsalary(4567d);
		employeeRepository.save(employee);
		return employee;

	}

	@RequestMapping(value = "/{eno}", method = RequestMethod.GET)
	public Employee getEmployee(@PathVariable Integer eno) {
		return this.employeeRepository.findByEno(eno);

	}

	@GetMapping("/getAll")
	@Cacheable("getEmpDetails")
	public ResponseEntity<Iterable<Employee>> getAllEmpData() {
System.out.println("Enter Into  GetAllEmpData");
		return ResponseEntity.ok(employeeRepository.findAll());
	}

	@PostMapping("updates")
	public ResponseEntity<Employee> update(@RequestBody Employee employee) {

		return ResponseEntity.ok(employeeRepository.save(employee));
	}

	@DeleteMapping("/delete/{eno}")
	public void deleteEmployee(@PathVariable Integer eno) {

		employeeRepository.deleteById(eno);
	}

}
