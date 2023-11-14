package com.eidiko.niranjana.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eidiko.niranjana.dto.AppointmentFormDTO;
import com.eidiko.niranjana.service.BookAppoimentService;

@RestController
@RequestMapping("/request")
public class BookAppointmentController 
{
	@Autowired
	private BookAppoimentService bookAppoimentService;
	
	@PostMapping("/book")
	public String bookAppointment(@RequestBody AppointmentFormDTO appointmentFormDTO)
	{
		return bookAppoimentService.bookAppointment(appointmentFormDTO);
	}
	
}
