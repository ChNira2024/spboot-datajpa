package com.eidiko.niranjana.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
@Table(name="eidiko_employee")
public class Employee 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int empId;
	private String empName;
	private String bloodGroup;

	@OneToOne(cascade = CascadeType.ALL)//here ForeignKey created in eidiko-employee table with name aadharCardNumber
	@JoinColumn(name="fk_aadharCard_number")
	private PersonalInfo personalInfo;
}
