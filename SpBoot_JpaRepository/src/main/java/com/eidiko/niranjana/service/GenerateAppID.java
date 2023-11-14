package com.eidiko.niranjana.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.stereotype.Service;

import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
@Service
public class GenerateAppID 
{
	public    Map<String,String>  generateAppId() throws NoSuchFieldException, SecurityException
	{
		// Created Applicaion ID with Date
		Random random = new Random();
		int x = random.nextInt(90000);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("ddMMyyyy");  
		LocalDateTime now = LocalDateTime.now();  
		
		String appId = "CCMS"+x+dtf.format(now);
		String caseReferenceNumber = "MSQ"+x;
		
		//Created Date with format
		DateTimeFormatter dtff = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");  
		LocalDateTime noww = LocalDateTime.now();  
		String CreatedDate = dtff.format(noww);
		
		
		Map<String, String> map = new HashMap<>();
		map.put("APPLICATION_ID", appId);
		map.put("CASE_REFERENCE_NUMBER", caseReferenceNumber);
		map.put("CREATED_DATE", CreatedDate);
		
		System.out.println("MAP VALUE: "+map);
		System.out.println("APPLICATION ID: "+map.get("APPLICATION_ID"));
		System.out.println("CASE REFERENCE NUMBER: "+map.get("CASE_REFERENCE_NUMBER"));
		System.out.println("CREATED DATE:: "+map.get("CREATED_DATE"));
		return map;
	}

}
