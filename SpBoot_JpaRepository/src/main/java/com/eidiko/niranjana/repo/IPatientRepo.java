package com.eidiko.niranjana.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eidiko.niranjana.entity.Patient;

public interface IPatientRepo extends JpaRepository<Patient, String> {

}
