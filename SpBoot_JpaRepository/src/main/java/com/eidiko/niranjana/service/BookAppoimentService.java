package com.eidiko.niranjana.service;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eidiko.niranjana.dto.AppointmentFormDTO;
import com.eidiko.niranjana.entity.Appointment;
import com.eidiko.niranjana.entity.Patient;
import com.eidiko.niranjana.repo.IAppointmentRepo;
import com.eidiko.niranjana.repo.IPatientRepo;
@Service
@Transactional
public class BookAppoimentService 
{
	@Autowired
	private IPatientRepo patientRepo;

	@Autowired
	private IAppointmentRepo appointmentRepo;
	
	public String bookAppointment(AppointmentFormDTO appointmentFormDTO)
	{
		//AppointmentFormDTO fields and Patient fields are both same so simply convertion happend here
		//using this single line directly we can pass appointmentFormDTO object data to Patient class so no need of setter and getter concept
		
		/*Patient patient =  new ObjectMapper().convertValue(appointmentFormDTO, Patient.class);*/
		
		Patient patient = new Patient();
		patient.setAge(appointmentFormDTO.getAge());
		patient.setGender(appointmentFormDTO.getGender());
		patient.setMobile(appointmentFormDTO.getMobile());	
		patient.setName(appointmentFormDTO.getName());		
		Long patientNo = patientRepo.save(patient).getPatientNo();		
		System.out.println("Patient Saved Successfully!!!");
		System.out.println(10/0);
		Appointment appointment = Appointment.builder().date(new Date(System.currentTimeMillis())).doctorNo(101l).patientNo(patientNo).build();	
		Long appointmentNo = appointmentRepo.save(appointment).getAppointmentNo();
		return "Appointment booked Successfully!! With: "+appointmentNo;
	}
	
}
