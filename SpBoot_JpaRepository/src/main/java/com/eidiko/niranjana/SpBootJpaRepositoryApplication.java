package com.eidiko.niranjana;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.eidiko.niranjana.service.GenerateAppID;

@SpringBootApplication
public class SpBootJpaRepositoryApplication 
{

	public static void main(String[] args) throws NoSuchFieldException, SecurityException 
	{
		ApplicationContext context = SpringApplication.run(SpBootJpaRepositoryApplication.class, args);
		
		
		
		
		
		GenerateAppID id = new GenerateAppID();
		id.generateAppId();
	}
}
