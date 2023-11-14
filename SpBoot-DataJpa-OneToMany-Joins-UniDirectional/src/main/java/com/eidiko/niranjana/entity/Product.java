package com.eidiko.niranjana.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@AllArgsConstructor 
@NoArgsConstructor
@ToString
@Setter
@Getter
public class Product 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int pid;
	private String productName;
	private String qty;
	private String price;
}
