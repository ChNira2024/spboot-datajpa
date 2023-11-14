package com.eidiko.niranjana.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eidiko.niranjana.entity.CustomerDetailsEntity;
import com.eidiko.niranjana.service.GenerateAppID;
import com.eidiko.niranjana.service.ICustomerDetailsService;

@RestController
@RequestMapping("/customer")
public class CustomerDetailsController 
{
	/*
	 * static String CreatedDate = null; static String appid = null; static String
	 * casereferenceNumber = null; static { // Created Applicaion ID with Date
	 * Random random = new Random(); int x = random.nextInt(90000);
	 * DateTimeFormatter dtf = DateTimeFormatter.ofPattern("ddMMyyyy");
	 * LocalDateTime now = LocalDateTime.now();
	 * System.out.println("APPLICATION ID: "+"CCMS"+x+dtf.format(now)); appid =
	 * "CCMS"+x+dtf.format(now); casereferenceNumber = "CCMS"+x+dtf.format(now);
	 * 
	 * //Created Date with format DateTimeFormatter dtff =
	 * DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"); LocalDateTime noww =
	 * LocalDateTime.now(); System.out.println("Created Date: "+dtff.format(noww));
	 * CreatedDate = dtff.format(noww); }
	 */
	@Autowired
	private ICustomerDetailsService service;
	
	@Autowired
	private GenerateAppID generateID;
	
	@PostMapping("/dataSave")
	public ResponseEntity<String> saveCustomerDetails(@RequestBody CustomerDetailsEntity data) throws NoSuchFieldException, SecurityException
	{
		System.out.println("--------saveCustomerDetails in Controller class----------");
		/*
		String taskid=	generateID.generateAppId().get("APPLICATION_ID");
		System.out.println("taskid "+taskid);
		
		String casereferenceNumber = generateID.generateAppId().get("CASE_REFERENCE_NUMBER");
		System.out.println("casereferenceNumber "+casereferenceNumber);
		
		String CreatedDate = generateID.generateAppId().get("CREATED_DATE");
		System.out.println("Created Date: "+CreatedDate);
		*/
		
		// Created Applicaion ID with Date
		final Random random = new Random();
		int x = random.nextInt(90000);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("ddMMyyyy");  
		LocalDateTime now = LocalDateTime.now();  
		
		String taskid = "CCMS"+x+dtf.format(now);
		String casereferenceNumber = "MSQ"+x;
		
		//Created Date with format
		DateTimeFormatter dtff = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");  
		LocalDateTime noww = LocalDateTime.now();  
		String CreatedDate = dtff.format(noww);
		
		System.out.println("taskid: "+taskid);
		System.out.println("casereferenceNumber: "+casereferenceNumber);
		System.out.println("CreatedDate: "+CreatedDate);
		
		String insertedData = service.registerCustomerData(taskid,casereferenceNumber,CreatedDate,data.getCustomerName(),data.getCifNumber(),data.getCivilId(),data.getPassportNumber(),data.getMobileNumber());
		//return ResponseEntity.ok(insertedData); //also work
		return new ResponseEntity<String>(insertedData,HttpStatus.OK);
	}
	
	@GetMapping("/fetchUsingCIF")
	public ResponseEntity<List<CustomerDetailsEntity>> fetchCustomerDetailsUsingCifNumber(@RequestParam("CIF_NUMBER") String cifNumber)
	{
		List<CustomerDetailsEntity> data = service.fetchCustomerDataUsingCifNumber(cifNumber);
		return ResponseEntity.status(HttpStatus.OK).body(data);		
	}
	
	@GetMapping("/fetchUsingCivilId")
	public ResponseEntity<List<CustomerDetailsEntity>> fetchCustomerDetailsUsingCivilId(@RequestParam("CIVIL_ID") String civilId)
	{
		List<CustomerDetailsEntity> data = service.fetchCustomerDataUsingCivilId(civilId);
		return ResponseEntity.status(HttpStatus.OK).body(data);		
	}
	

}
