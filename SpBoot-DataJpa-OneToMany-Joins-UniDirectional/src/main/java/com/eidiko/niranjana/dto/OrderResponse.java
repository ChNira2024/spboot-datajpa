package com.eidiko.niranjana.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class OrderResponse 
{
	private String name;
	private String productName;
	private String price;//ignore property
	
	public OrderResponse(String name, String productName) {
		super();
		this.name = name;
		this.productName = productName;
	}
	
	

}
