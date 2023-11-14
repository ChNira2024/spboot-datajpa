package com.eidiko.niranjana.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Customer 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String email;
	private String gender;

	@OneToMany(targetEntity = Product.class,cascade = CascadeType.ALL)
	@JoinColumn(name="cp_fk",referencedColumnName = "id") 
	private List<Product> products;                                    
}
//Here "fk_aadharCard_number" is the ForeignKey of "customer" table having all the details of table "product"
//referencedColumnName = "id" means Here "id" is the ForeignKey of product table having all the details of customer
//cascade = CascadeType.ALL means it can insert data into child table also(product)
