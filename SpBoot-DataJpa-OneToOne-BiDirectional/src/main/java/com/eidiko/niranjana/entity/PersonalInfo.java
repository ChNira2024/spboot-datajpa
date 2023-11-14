package com.eidiko.niranjana.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="jpa_personalinfo")
public class PersonalInfo 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int aadharCardNumber;
	private String voteCardNumber;
	private String panCardNumber;

	@OneToOne(mappedBy = "personalInfo")
	@JsonBackReference    //used for to solve looping in child class(stop conversion of child data to JSON)
	private Employee employee;
}