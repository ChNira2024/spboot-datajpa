package com.eidiko.niranjana.controller;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eidiko.niranjana.entity.Students;
import com.eidiko.niranjana.repo.IStudentsRepo;
import com.eidiko.niranjana.repo.IStudentsRepo2;

@RestController
public class StudentsController {
		
	@Autowired
	private IStudentsRepo repo;
	
	@Autowired
	private IStudentsRepo2 repo2;

	@GetMapping("/fetchAllData")
	public List<Students> fetchAllStudentsData()
	{		
		List<Students> list = null;
		list = repo.fetchAllStudents(); //it display POSTMAN response
		repo.fetchAllStudents().forEach(System.out::println); //it display in Console
		return list;
	}
	
	@GetMapping("/fetchAllData2")
	public List<Students> fetchAllStudentsData2()
	{		
		List<Students> list = null;
		list = repo2.fetchAllStudents(); //it display POSTMAN response
		repo.fetchAllStudents().forEach(System.out::println); //it display in Console
		return list;
	}
	
	//fetch all students data by through ID, using "named param"
	@GetMapping("/fetchByIdNamedParam/{sno}")
	public Object fetchPartialStudentsDataById(@PathVariable Integer sno)
	{
		System.out.println("Fetch Students Data By ID");
		Object obj = repo.findStdPartialDetailsById(sno);
		 Object row[]=(Object[])obj;
		 System.out.println("fetchByIdNamedParam details are::"+row[0]+"  "+row[1]+" "+row[2]+" "+row[3]);
		return row;
	}
	//fetch all students data by through NAME, using "named param"
	@GetMapping("/fetchByNameNamedParam/{sname}")
	public Object fetchPartialStudentsDataByName(@PathVariable String sname)
	{
		System.out.println("Fetch Students Data By Name");
		Object obj = repo.findStdPartialDetailsByName(sname);
		 Object row[]=(Object[])obj;
		 System.out.println("fetchByNameNamedParam details are::"+row[0]+"  "+row[1]+" "+row[2]+" "+row[3]);
		return row;
	}
	
//============================================================================
	
	
	//fetch all students data by through NAME, using @Param annotation
		@GetMapping("/fetchByNamePositionalParam")
		public Object fetchAllStudentsDataByName(@RequestParam(name="sname") String sname)
		{
			System.out.println("Fetch Students Data By Name");
			Object obj =  repo.fetchStudentsAllDetailsByName(sname);
			 Object row[]=(Object[])obj;
			 System.out.println("fetchByNamePositionalParam details are::"+row[0]+"  "+row[1]+" "+row[2]+" "+row[3]);
			return row;
		}
		
	//fetch all students data by through NAME, using @Param annotation
	@GetMapping("/fetchByIdPositionalParam")
	public Object fetchAllStudentsDataById(@RequestParam(name="sno") Integer sno)
	{
		System.out.println("Fetch Students Data By No");
		Object obj =  repo.fetchStudentsAllDetailsById(sno);
		Object row[]=(Object[])obj;
		System.out.println("fetchByIdPositionalParam details are::"+row[0]+"  "+row[1]+" "+row[2]+" "+row[3]);
		return row;
	}
	
	//fetch all students data by through SADDRS, using @Param annotation
		@GetMapping("/fetchByAddrsPositionalParam")
		public List<Students> fetchAllStudentsDataByAddrs(@RequestParam(name="saddrs") String saddrs)
		{
			List<Students> list = null;
			System.out.println("Fetch Students Data By Addrs");
			list =  repo.fetchAllStudentsDetailsByAddrs(saddrs);
			Iterator iterator = list.iterator();
		    while(iterator.hasNext())
		    {
		         System.out.println(iterator.next());
		    }
		    return list;
		}
		
	//fetch all students data by through SADDRS
	@GetMapping("/fetchBySalaryRangePositionalParam")
	public List<Students> fetchAllStudentsDataBySalaryRange(@RequestParam(name="startingSalary") Float ssal, @RequestParam(name="endingSalary") Float ssall)
	{
		List<Students> list = null;
		System.out.println("Fetch Students Data By Salary Range");
		System.out.println(ssal);
		System.out.println(ssall);
		list =  repo.fetchStudentsDetailsBySalaryrange(ssal, ssall);
		Iterator iterator = list.iterator();
		while(iterator.hasNext())
		 {
		 System.out.println(iterator.next());
		}
	 return list;
	}
	
	//fetch all students data by through SADDRS
		@GetMapping("/fetchBySnoRangePositionalParam")
		public List<Students> fetchAllStudentsDataBySnoRange(@RequestParam(name="startingSno") Integer sno1, @RequestParam(name="endingSno") Integer sno2)
		{
			List<Students> list = null;
			System.out.println("Fetch Students Data By Salary Range");
			System.out.println(sno1);
			System.out.println(sno2);
			list =  repo.fetchStudentsDetailsBySnoRange(sno1, sno2);
			Iterator iterator = list.iterator();
			while(iterator.hasNext())
			 {
			 System.out.println(iterator.next());
			}
		 return list;
		}
	
	/*
	//fetch all students data between  the cities
	//Failed to convert from type [java.lang.Object[]] to type [@org.springframework.data.jpa.repository.Query com.eidiko.niranjana.entity.Students] 
		//for value '{3, ABHINASH, 30000.0}
	@GetMapping("/fetchByBetCityPositionalParam1")
	public List<Students> fetchAllStudentsDataBetwnCities1(@RequestParam(name="startingCity") String city1, @RequestParam(name="endingCity") String city2)
	{
			List<Students> list = null;
			System.out.println("Fetch Students Data Between Cities");
			System.out.println(city1);
			System.out.println(city2);
			list= repo.fetchStudentsDetailsByCities1(city1, city2);
			Iterator iterator = list.iterator();
			while(iterator.hasNext())
			{
				System.out.println(iterator.next());
			}
			return list;
	}		
	*/
	
	//fetch all students data between  the cities
		@GetMapping("/fetchByBetCityPositionalParam")
		public List<Object> fetchAllStudentsDataBetwnCities(@RequestParam(name="startingCity") String city1, @RequestParam(name="endingCity") String city2)
		{
			List<Object> list = null;
			System.out.println("Fetch Students Data Between Cities");
			System.out.println(city1);
			System.out.println(city2);
			list= repo.fetchStudentsDetailsByCities(city1, city2);
			Iterator iterator = list.iterator();
			while(iterator.hasNext())
			 {
			 System.out.println(iterator.next());
			}
		 return list;
		}
		
//		//fetch all students data using its firstLetter
//		@GetMapping("/fetchByfirstLetter")
//		public List<Object> fetchAllStudentsDataByfirstLetter(@RequestParam(name="firstLetter") String S)
//		{
//					List<Object> list = null;
//					System.out.println("Fetch Students Data Between Cities");
//					System.out.println(S);
//					list= repo.fetStudentsDetailsByUsingInitialLetter(S);
//					Iterator iterator = list.iterator();
//					while(iterator.hasNext())
//					 {
//					 System.out.println(iterator.next());
//					}
//				 return list;
//		}
		
		//Count number of Students 
		@GetMapping("/count")
		public int countTotalStudents()
		{
			return repo.getStudCount();
		}
}
