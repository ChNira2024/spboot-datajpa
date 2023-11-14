package com.eidiko.niranjana.dto;

import com.eidiko.niranjana.entity.Customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderRequest 
{
	private Customer customer;

}
