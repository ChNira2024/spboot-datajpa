package com.eidiko.niranjana.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eidiko.niranjana.entity.Product;

public interface IProductRepository extends JpaRepository<Product, Integer> 
{

}
