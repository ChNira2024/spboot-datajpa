package com.eidiko.niranjana.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eidiko.niranjana.entity.PersonalInfo;

public interface IPersonalInfoRepository extends JpaRepository<PersonalInfo, Integer> 
{

}
