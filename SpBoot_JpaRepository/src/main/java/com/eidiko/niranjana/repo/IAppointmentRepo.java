package com.eidiko.niranjana.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eidiko.niranjana.entity.Appointment;

public interface IAppointmentRepo extends JpaRepository<Appointment, String> {

}
