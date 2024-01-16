package com.marketing.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marketing.entity.Customer;
import java.util.List;


public interface CustomerRepository extends JpaRepository<Customer, Long>
{
//	public void deletByEmail(String email);
	public Customer findByEmail(String email);

}
