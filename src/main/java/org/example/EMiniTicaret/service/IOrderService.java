package org.example.EMiniTicaret.service;

import org.example.EMiniTicaret.entities.Order;
import org.example.EMiniTicaret.entities.OrderItem;

import java.util.List;

public interface IOrderService {
    Order createOrder(String orderId, String customerId, List<OrderItem> items);
    Order findOrderById(String id);
    List<Order> getCustomerOrders(String customerId);
    void displayOrderDetails(String orderId);
    void displayOrderStatistics();
}
