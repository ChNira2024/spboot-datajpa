package com.eidiko.niranjana.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eidiko.niranjana.entity.ReserveFundSaveData;
import com.eidiko.niranjana.exception.ResourceNotFoundException;
import com.eidiko.niranjana.repo.ReserveFundDetailsRepo;
import com.eidiko.niranjana.service.ReserveFundDetailsService;

@Service
public class ReserveFundDetailsServiceImpl implements ReserveFundDetailsService {

	@Autowired
	private ReserveFundDetailsRepo repo;

//==============================findAll========================================
	@Override
	public List<ReserveFundSaveData> retrieveReserveFundDetailsData() {
		return  repo.findAll();
	}
	
//=================================findAllById=======================================
//	@Override
//	public List<ReserveFundDetails> retrieveReserveFundDetailsDataById(Iterable<Integer> id) {
//		System.out.println("------findAllById method5--------");
//		return repo.findAllById(id);
//	}
//=============================findById==================================
	@Override
	public ReserveFundSaveData retrieveReserveFundDataById(Integer id) {
		System.out.println("service method");
		return repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Given Id not Present: "+id));
	}
//=================================save===============================================================
	@Override
	public ReserveFundSaveData saveUser(ReserveFundSaveData rfd) {
		return repo.save(rfd);
	}

	
	
	
//	@Override
//	public Optional<ReserveFundDetails> retrieveReserveFundDataById(Integer id) throws IllegalArgumentException {
//		return Optional.ofNullable(repo.findById(id).orElseThrow(()->new IllegalArgumentException("record not found")));//if record not there then IllegalArgException message raise
//	}
	
//	@Override
//	public ReserveFundDetails retrieveReserveFundDataById(Integer id) {
//		return repo.findById(id).orElse(new ReserveFundDetails());//if record not there then we get empty ReservefundDetails object
//	}

}
