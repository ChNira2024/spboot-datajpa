package com.eidiko.niranjana.service;

import java.util.List;

import com.eidiko.niranjana.entity.Employee;
import com.eidiko.niranjana.entity.PersonalInfo;

public interface IEmployeeService 
{
	List<Employee> saveEmployeeDataIntoDb(List<Employee> empdata);
	
	List<Employee>fetchAllEmployeeData();
	
	Employee getEmployeeDataByUsingItsForeignKey(int key);


	PersonalInfo getEmployeeDataByUsingItsAadharNumber(int no);
}
