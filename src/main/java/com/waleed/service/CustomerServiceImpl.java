package com.waleed.service;

import com.waleed.entity.Customer;
import com.waleed.exception.CustomerNotFoundException;
import com.waleed.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer createCustomer(Customer user) {
        return customerRepository.save(user);
    }

    @Override
    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException("Customer with id: " + id + " not found"));
    }

    public Customer updateCustomer(Long customerId, Customer updatedCustomer){
        Customer existingCustomer = customerRepository.findById(customerId)
                .orElseThrow(() -> new CustomerNotFoundException("Customer with id: " + customerId + " not found"));

        existingCustomer.setCustomerName(updatedCustomer.getCustomerName());
        existingCustomer.setCustomerEmail(updatedCustomer.getCustomerEmail());

        return customerRepository.save(existingCustomer);
    }

    public void deleteCustomerById(Long customerId){
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new CustomerNotFoundException("Customer with id: " + customerId + " not found"));
        customerRepository.delete(customer);
    }
}
