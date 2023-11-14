package com.eidiko.niranjana.service;

import java.util.List;

import com.eidiko.niranjana.entity.ReserveFundSaveData;

public interface ReserveFundDetailsService {

	//findAll() method
	public List<ReserveFundSaveData> retrieveReserveFundDetailsData();	
	
	//findAllById(Iterable<ID> id)
	//public List<ReserveFundDetails> retrieveReserveFundDetailsDataById(Iterable<Integer> id);
	
	
	//findById(Integer id)
	public ReserveFundSaveData retrieveReserveFundDataById(Integer id);
	
	//save user
	public ReserveFundSaveData saveUser(ReserveFundSaveData rfd);

}
