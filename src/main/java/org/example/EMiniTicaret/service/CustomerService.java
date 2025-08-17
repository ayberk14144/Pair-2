package org.example.EMiniTicaret.service;
import org.example.EMiniTicaret.entities.*;
import java.util.ArrayList;
import java.util.List;
public class CustomerService {
    private final List<Customer> customers = new ArrayList<>();
    private int nextId = 1;
    public Customer addCustomer(Customer customer) {
        if(customer==null){
            throw new IllegalArgumentException("Customer cannot be null ");
        }
        if(customer.getName()==null || customer.getName().isBlank()){
            throw new IllegalArgumentException("Customer name is required ");

        }
        if (customer.getEmail()==null || customer.getEmail().isBlank()){
            throw new IllegalArgumentException("Customer email is required");
        }
        for(Customer c : customers){
            if(c.getEmail().equalsIgnoreCase(customer.getEmail())){
                throw new IllegalArgumentException("Email already exists! ");
            }
        }
        customer.setId(nextId++);
        customers.add(customer);
        return customer;
    }
    public List<Customer> search(String query){
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
        return result;
    }

}


