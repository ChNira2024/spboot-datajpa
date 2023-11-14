package com.eidiko.niranjana.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eidiko.niranjana.entity.Employee;

public interface IEmployeeRepository extends JpaRepository<Employee, Integer>
{

}
