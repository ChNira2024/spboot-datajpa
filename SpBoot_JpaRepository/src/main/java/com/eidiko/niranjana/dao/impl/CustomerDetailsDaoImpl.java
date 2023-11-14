package com.eidiko.niranjana.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.eidiko.niranjana.dao.ICustomerDetailsDao;
import com.eidiko.niranjana.entity.CustomerDetailsEntity;
@Service
public class CustomerDetailsDaoImpl implements ICustomerDetailsDao 
{
	@Autowired
	private JdbcTemplate jt;


	@Override
	public String registerCustomerDataInDB(String taskId, String caseReferenceNumber,String createdDate,String customerName,String cifNumber,String civilId,String passportNumber,String mobileNumber) 
	{
		int count=0;
		String INSERT_QUERY = "insert into ccms_customerdetailsentity(task_id,case_reference_number,created_date,customer_name,cif_number,civil_id,passport_number,mobile_number)values(?,?,?,?,?,?,?,?)";
		System.out.println("-------------registerCustomerDataInDB dao method===========");
		count = jt.update(INSERT_QUERY, taskId,caseReferenceNumber,createdDate,customerName,cifNumber,civilId,passportNumber,mobileNumber);
		return "data inserted "+count;
	}


	@Override
	public List<CustomerDetailsEntity> CustfetchCustomerDataUsingCifNumber(String cifNumber)
	{	
		List<CustomerDetailsEntity> data = null;
			if(cifNumber.length()==6 )
			{
				String SELECT_QUERY = "select task_id,case_reference_number,created_date,customer_name,cif_number,civil_id,passport_number,mobile_number from ccms_customerdetailsentity where cif_number=?";
				data = jt.query(SELECT_QUERY, new Object[] { cifNumber },BeanPropertyRowMapper.newInstance(CustomerDetailsEntity.class));
			}
			else {
				System.out.println("CIF should be 6 digit");
			}
		return data;
	}
	@Override
	public List<CustomerDetailsEntity> CustfetchCustomerDataUsingCivilId(String civilId)
	{	
		List<CustomerDetailsEntity> data = null;
			if(civilId.length()==8 )
			{
				String SELECT_QUERY = "select task_id,case_reference_number,created_date,customer_name,cif_number,civil_id,passport_number,mobile_number from ccms_customerdetailsentity where civil_id=?";
				data = jt.query(SELECT_QUERY, new Object[] { civilId },BeanPropertyRowMapper.newInstance(CustomerDetailsEntity.class));
			}
			else {
				System.out.println("CivilID should be 8 digit");
			}
		return data;
	}


	


	
}
