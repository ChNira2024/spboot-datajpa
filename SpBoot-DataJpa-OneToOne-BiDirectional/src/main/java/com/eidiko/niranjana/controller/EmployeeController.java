package com.eidiko.niranjana.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eidiko.niranjana.entity.Employee;
import com.eidiko.niranjana.entity.PersonalInfo;
import com.eidiko.niranjana.service.IEmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController 
{
	@Autowired
	private IEmployeeService service;
	
	@PostMapping("/savedata")
	public ResponseEntity<String>saveEmployees(@RequestBody List<Employee> empData)
	{
		service.saveEmployeeDataIntoDb(empData);
		return ResponseEntity.ok("Data Saved");
	}
	@GetMapping("/fetchAllData")
	public ResponseEntity<List<Employee>>fetchAllEmployees()
	{
		List<Employee> empList = service.fetchAllEmployeeData();
		return ResponseEntity.ok(empList);
	}
	
	@GetMapping("/fetchEmployeeDataByUsingFK/{key}")
	public ResponseEntity<Employee>fetchEmployeedataByUsingFK(@PathVariable int key)
	{
		Employee empList = service.getEmployeeDataByUsingItsForeignKey(key);
		return ResponseEntity.ok(empList);
	}
	
	@GetMapping("/fetchEmployeeByUsingAadharNo/{no}")
	public ResponseEntity<PersonalInfo>fetchEmployeedataByUsingAadharNo(@PathVariable int no)
	{
		PersonalInfo empList = service.getEmployeeDataByUsingItsAadharNumber(no);
		return ResponseEntity.ok(empList);
	}

}
