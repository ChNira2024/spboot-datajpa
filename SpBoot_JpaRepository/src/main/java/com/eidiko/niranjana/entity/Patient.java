package com.eidiko.niranjana.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Patient 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long patientNo;  
	private String name;  
	private String gender;   
	private String mobile;  
	private int age;

}
