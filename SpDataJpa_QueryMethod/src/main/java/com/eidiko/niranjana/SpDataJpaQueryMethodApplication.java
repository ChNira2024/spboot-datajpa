package com.eidiko.niranjana;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.eidiko.niranjana.repo.IStudentsRepo;

@SpringBootApplication
public class SpDataJpaQueryMethodApplication {
		
	public static void main(String[] args) {
		//get IOC container
		ApplicationContext ctx = SpringApplication.run(SpDataJpaQueryMethodApplication.class, args);
		//get Proxy class object
		IStudentsRepo repo=ctx.getBean(IStudentsRepo.class);
		//------------------------- Retrieving specific multiple   col values of singlerow (scalar/Projection Operation in SingleRow Select query ) --------------------------
		 Object obj=repo.findStdPartialDetailsById(1);
		 Object row[]=(Object[])obj;
		 System.out.println("Students details By using its ID::"+row[0]+"  "+row[1]+" "+row[2]+" "+row[3]);
		 
		 //fetch Students details by using forEach method(Method Reference)
		 System.out.println("..............................");
		 repo.fetchAllStudents().forEach(System.out::println);
	}

}
