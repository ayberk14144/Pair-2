package org.example.EMiniTicaret.repository;

import org.example.EMiniTicaret.entities.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerRepository implements IRepository<Customer> {
    private List<Customer> customers = new ArrayList<>();

    @Override
    public void add(Customer entity) {
        customers.add(entity);
    }

    @Override
    public void remove(int id) {
        customers.removeIf(c -> c.getId() == id);
    }

    @Override
    public Customer findById(int id) {
        return customers.stream()
                .filter(c -> c.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Customer> findAll() {
        return customers;
    }
}