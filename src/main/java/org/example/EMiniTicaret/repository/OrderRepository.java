package org.example.EMiniTicaret.repository;

import org.example.EMiniTicaret.entities.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderRepository implements IRepository<Order> {
    List<Order> order = new ArrayList<>();

    public List<Order> findAll() {
        return order;
    }

    public Order findById(int id) {
        return order.stream().filter(order -> order.getId() == id).findFirst().orElse(null);

    }

    public void add(Order order1) {
        order.add(order1);
    }

    public void remove(int id) {
        order.remove(order.stream().filter(order -> order.getId() == id).findFirst().orElse(null));
        System.out.println(id + "'li veri silindi.");
    }

}
