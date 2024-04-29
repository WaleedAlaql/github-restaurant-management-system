package com.waleed.service;

import com.waleed.entity.Customer;
import java.util.List;

public interface CustomerService {

    List<Customer> getAllCustomers();

    Customer getCustomerById(Long id);

    Customer createCustomer(Customer user);
}
