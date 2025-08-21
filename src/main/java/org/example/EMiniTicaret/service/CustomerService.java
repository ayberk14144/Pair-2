package org.example.EMiniTicaret.service;

import org.example.EMiniTicaret.entities.*;
import org.example.EMiniTicaret.repository.CustomerRepository;

import java.util.ArrayList;
import java.util.List;

public class CustomerService implements ICustomerService {
    private final List<Customer> customers = new ArrayList<>();
    private final CustomerRepository customerRepository;
    private int nextId = 1;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer addCustomer(Customer customer) {
        if (customer == null) {
            throw new IllegalArgumentException("Customer cannot be null ");
        }
        if (customer.getName() == null || customer.getName().isBlank()) {
            throw new IllegalArgumentException("Customer name is required ");

        }
        if (customer.getEmail() == null || customer.getEmail().isBlank()) {
            throw new IllegalArgumentException("Customer email is required");
        }
        for (Customer c : customers) {
            if (c.getEmail().equalsIgnoreCase(customer.getEmail())) {
                throw new IllegalArgumentException("Email already exists! ");
            }
        }
        customer.setId(nextId++);
        customers.add(customer);
        System.out.println(customer + "added");
        return customer;
    }

    public List<Customer> search(String query) {
        if (query == null || query.isBlank()) {
            return new ArrayList<>(customers);
        }
        String q = query.toLowerCase();
        List<Customer> result = new ArrayList<>();
        for (Customer c : customers) {
            if ((c.getName() != null && c.getName().toLowerCase().contains(q)) ||
                    (c.getEmail() != null && c.getEmail().toLowerCase().contains(q)) ||
                    (c.getPhone() != null && c.getPhone().contains(query))) {
                result.add(c);
            }
        }
        for (Customer cs : result)
            System.out.println("id : " + cs.getId() + "email : " + cs.getEmail() + " name :  " + cs.getName() + " phone : " + cs.getPhone());

        return result;
    }
    @Override
    public Customer findById(int id ){
       return   customerRepository.findById(id);
    }

}


