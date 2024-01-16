package com.marketing.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.marketing.entity.Customer;
import com.marketing.repository.CustomerRepository;

@Service
public class CustomerServiceImplementaion implements CustomerService
{

	@Autowired
	private CustomerRepository cr;
	
	@Override
	public void saveCustomer(@ModelAttribute Customer customer) {
		// TODO Auto-generated method stub
		this.cr.save(customer);
		
	}

	@Override
	public List<Customer> getAllCustomer() {
		List<Customer> customer = this.cr.findAll();
		return customer;
	}

	@Override
	public void deleteCustomer(String email) {
		Customer c = this.cr.findByEmail(email);
		long id = c.getId();
		this.cr.deleteById(id);
	}

	@Override
	public Customer findCustomer(String email) {
		return this.cr.findByEmail(email);
		
	}

	@Override
	public void updateCustomer(Customer customer) {
		this.cr.save(customer);
		
	}
	
	@Override
	public boolean emailExist(String email) {
		if(cr.findByEmail(email) == null)
		{
			return false;
		}
		else {
			return true;
		}
	}

}
