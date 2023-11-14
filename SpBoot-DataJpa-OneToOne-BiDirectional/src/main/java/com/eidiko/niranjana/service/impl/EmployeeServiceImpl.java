package com.eidiko.niranjana.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eidiko.niranjana.entity.Employee;
import com.eidiko.niranjana.entity.PersonalInfo;
import com.eidiko.niranjana.exception.ResourceNotFoundException;
import com.eidiko.niranjana.repo.IEmployeeRepository;
import com.eidiko.niranjana.repo.IPersonalInfoRepository;
import com.eidiko.niranjana.service.IEmployeeService;

@Service
public class EmployeeServiceImpl implements IEmployeeService 
{

	@Autowired
	private IEmployeeRepository employeeRepo;
	
	@Autowired
	private IPersonalInfoRepository personalRepo;
	
	@Override
	public List<Employee> saveEmployeeDataIntoDb(List<Employee> empdata) 
	{
		return employeeRepo.saveAll(empdata);
	}
	@Override
	public List<Employee> fetchAllEmployeeData() 
	{
		return employeeRepo.findAll();
	}
	@Override
	public Employee getEmployeeDataByUsingItsForeignKey(int key) 
	{
		Employee data =  employeeRepo.findById(key).orElseThrow(()->new ResourceNotFoundException("Given Key "+key+" not Present"));
		return data;
	}
	@Override
	public PersonalInfo getEmployeeDataByUsingItsAadharNumber(int no) 
	{
		PersonalInfo data =  personalRepo.findById(no).orElseThrow(()->new ResourceNotFoundException("Given AadharNumber "+no+" not Present"));
		return data;
	}
}
