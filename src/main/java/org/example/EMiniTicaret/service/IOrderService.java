package org.example.EMiniTicaret.service;

import org.example.EMiniTicaret.entities.Order;
import org.example.EMiniTicaret.entities.OrderItem;

import java.util.List;

public interface IOrderService {
    Order createOrder(int orderId, int customerId, List<OrderItem> items);
    Order findOrderById(int id);
    List<Order> getCustomerOrders(int customerId);
    void displayOrderDetails(int orderId);
    void displayOrderStatistics();
}
