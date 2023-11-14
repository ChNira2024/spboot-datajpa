package com.eidiko.niranjana.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eidiko.niranjana.dao.ICustomerDetailsDao;
import com.eidiko.niranjana.entity.CustomerDetailsEntity;
import com.eidiko.niranjana.service.ICustomerDetailsService;
@Service
public class CustomerDetailsServiceImpl implements ICustomerDetailsService 
{
	@Autowired
	private ICustomerDetailsDao dao;

	@Override
	public String registerCustomerData(String taskId, String caseReferenceNumber, String createdDate,
			String customerName, String cifNumber, String civilId, String passportNumber, String mobileNumber) 
	{
		System.out.println("-------------registerCustomerData service method");
		return dao.registerCustomerDataInDB(taskId, caseReferenceNumber, createdDate, customerName, cifNumber, civilId, passportNumber, mobileNumber);
	}

	@Override
	public List<CustomerDetailsEntity> fetchCustomerDataUsingCifNumber(String cifNumber) 
	{
		return dao.CustfetchCustomerDataUsingCifNumber(cifNumber);
	}
	
	@Override
	public List<CustomerDetailsEntity> fetchCustomerDataUsingCivilId(String civilId) 
	{
		return dao.CustfetchCustomerDataUsingCivilId(civilId);
	}


	

}
