package com.eidiko.niranjana.service;

import java.util.List;

import com.eidiko.niranjana.entity.CustomerDetailsEntity;

public interface ICustomerDetailsService 
{
	public String registerCustomerData(String taskId, String caseReferenceNumber,String createdDate,String customerName,String cifNumber,String civilId,String passportNumber,String mobileNumber);

	public List<CustomerDetailsEntity> fetchCustomerDataUsingCifNumber(String cifNumber);
	public List<CustomerDetailsEntity> fetchCustomerDataUsingCivilId(String civilId);
}
