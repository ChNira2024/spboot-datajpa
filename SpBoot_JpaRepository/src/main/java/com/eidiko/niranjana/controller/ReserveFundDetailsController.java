package com.eidiko.niranjana.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eidiko.niranjana.entity.ReserveFundSaveData;
import com.eidiko.niranjana.service.ReserveFundDetailsService;

@RestController
@RequestMapping("/endpoint")
public class ReserveFundDetailsController {
	
	@Autowired
	private ReserveFundDetailsService service;
	
	
	//============================findAll() method===================================================		
	// Through POSTMAN
	@GetMapping("/fetchAllData")
	public ResponseEntity<List<ReserveFundSaveData>> reserveFundDataFetching()
	{
		List<ReserveFundSaveData> list = null;
		System.out.println(".........findAll method..............");
		try {
		 list = service.retrieveReserveFundDetailsData();
		System.out.println("ReserveFundDetails is :"+list);
		return ResponseEntity.ok(list);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Problem raise to fetching data");
		}
		return ResponseEntity.ok(list);
	}

	//================================findAllById() method===============================================
//	@GetMapping("/fetchAllDataById")
//	public List<ReserveFundDetails> reserveFundDataFetchingById()
//	{
//		System.out.println("------findAllById method--------");
//		List<Integer> list = new ArrayList<>();
//		list.add(5);
//		list.add(6);
//		System.out.println("------findAllById method2--------");
//		List<ReserveFundDetails>listDetail= service.retrieveReserveFundDetailsDataById(list);
//		System.out.println("------findAllById method3--------");
//		System.out.println("ReserveFundDetails data are:"+listDetail);
//		System.out.println("------findAllById method4--------");
//		for(ReserveFundDetails lists : listDetail)
//		{
//			System.out.println("Account Numbers are: "+lists.getACCOUNT_NUMBER());
//		}
//		return listDetail;
//	}

	//====================================findById() method===========================================
	@GetMapping("/{id}")
	public ResponseEntity<ReserveFundSaveData> reserveFundSpecificDataFetchingById(@PathVariable Integer id)
	{
		System.out.println("------findById method--------");
		ReserveFundSaveData details = service.retrieveReserveFundDataById(id);
		System.out.println("ReserveFundDetails data are :"+details);
		return ResponseEntity.ok(details);
	}
//============================save() method===============================================
	@PostMapping("/save")
	public ResponseEntity<ReserveFundSaveData> reserveFundDataSave(@RequestBody ReserveFundSaveData rfd)
	{
		System.out.println("------save method--------");
		ReserveFundSaveData details = service.saveUser(rfd);
		System.out.println("ReserveFundDetails data save into DB are :"+details);
		return ResponseEntity.status(HttpStatus.OK).body(details);
	}
	
	
}
