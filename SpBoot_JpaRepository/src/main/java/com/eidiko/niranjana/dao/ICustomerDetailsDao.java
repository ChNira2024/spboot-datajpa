package com.eidiko.niranjana.dao;

import java.util.List;

import com.eidiko.niranjana.entity.CustomerDetailsEntity;

public interface ICustomerDetailsDao 
{
	public String registerCustomerDataInDB(String taskId, String caseReferenceNumber,String createdDate,String customerName,String cifNumber,String civilId,String passportNumber,String mobileNumber);
	
	public List<CustomerDetailsEntity> CustfetchCustomerDataUsingCifNumber(String cifNumber);
	public List<CustomerDetailsEntity> CustfetchCustomerDataUsingCivilId(String civilId);

}
