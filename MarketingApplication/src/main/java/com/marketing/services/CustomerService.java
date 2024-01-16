package com.marketing.services;

import java.util.List;

import com.marketing.entity.Customer;

public interface CustomerService 
{
public void saveCustomer(Customer lead);
	
	public List<Customer> getAllCustomer();

	public void deleteCustomer(String email);
	
	public Customer findCustomer(String email);
	
	public void updateCustomer(Customer customer);
	
	public boolean emailExist(String email);

}
