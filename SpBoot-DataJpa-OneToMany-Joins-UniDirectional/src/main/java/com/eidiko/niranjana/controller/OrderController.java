package com.eidiko.niranjana.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eidiko.niranjana.dto.OrderRequest;
import com.eidiko.niranjana.dto.OrderResponse;
import com.eidiko.niranjana.entity.Customer;
import com.eidiko.niranjana.repo.ICustomerRepository;
import com.eidiko.niranjana.repo.IProductRepository;

@RestController
@RequestMapping("/order")
public class OrderController 
{
	@Autowired
	private ICustomerRepository customerRepository;
	
	@Autowired
	private IProductRepository productRepository;
	
	@PostMapping("/placeorder")
	public Customer placeOrder(@RequestBody OrderRequest request)
	{
		return customerRepository.save(request.getCustomer());
	}
	@GetMapping("/fetchAllOrder")
	public List<Customer>fetchAllOrderdDetails()
	{
		return customerRepository.findAll();
	}
	
	@GetMapping("/getInfo")
	public List<OrderResponse> getJoinInformation()
	{
		return customerRepository.getJoinInformation();
	}
}
