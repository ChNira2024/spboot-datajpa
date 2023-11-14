package com.eidiko.niranjana.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.eidiko.niranjana.dto.OrderResponse;
import com.eidiko.niranjana.entity.Customer;

public interface ICustomerRepository extends JpaRepository<Customer, Integer>
{

	@Query("SELECT new com.eidiko.niranjana.dto.OrderResponse(c.name,p.productName) FROM Customer c JOIN c.products p")
	public List<OrderResponse>getJoinInformation();
}
