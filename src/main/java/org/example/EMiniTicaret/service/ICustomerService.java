package org.example.EMiniTicaret.service;

import org.example.EMiniTicaret.entities.Customer;

import java.util.List;

public interface ICustomerService {
    Customer findById(int id);

    Customer addCustomer(Customer customer);

    List<Customer> search(String query);
}
