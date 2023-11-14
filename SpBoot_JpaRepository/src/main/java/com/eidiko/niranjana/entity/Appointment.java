package com.eidiko.niranjana.entity;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Builder
public class Appointment 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long appointmentNo;
	private Date date;
	private Long doctorNo;
	private Long  patientNo;
}
