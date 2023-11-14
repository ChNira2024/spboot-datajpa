package com.eidiko.niranjana.main;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class GenerateRandomAppIDWithDate 
{
	public static void main(String[] args) {
		
		
				// Created Applicaion ID with Date
				Random random = new Random();
				int x = random.nextInt(90000);
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("ddMMyyyy");  
				LocalDateTime now = LocalDateTime.now();  
				System.out.println("APPLICATION ID: "+"CCMS"+x+dtf.format(now));  
				
				//Created Date with format
				DateTimeFormatter dtff = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");  
				LocalDateTime noww = LocalDateTime.now();  				
				System.out.println("Created Date: "+dtff.format(noww));  
				
	}

}
