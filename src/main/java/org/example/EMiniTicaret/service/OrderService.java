package org.example.EMiniTicaret.service;

import org.example.EMiniTicaret.entities.*;
import org.example.EMiniTicaret.repository.*;

import java.util.ArrayList;
import java.util.List;

public class OrderService implements IOrderService {
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final CustomerRepository customerRepository;

    public OrderService(OrderRepository orderRepository,
                        ProductRepository productRepository,
                        CustomerRepository customerRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public Order createOrder(int orderId, int customerId, List<OrderItem> items) {
        // Müşteri var mı?
        Customer customer = customerRepository.findById(customerId);
        if (customer == null) {
            throw new RuntimeException("Müşteri bulunamadı");
        }

        // Sipariş boş mu?
        if (items == null || items.isEmpty()) {
            throw new RuntimeException("Sipariş boş olamaz");
        }

        // Stok kontrol et
        for (OrderItem item : items) {
            Product product = productRepository.findById(item.getProductId());
            if (product == null) {
                throw new RuntimeException("Ürün bulunamadı: " + item.getProductId());
            }
            if (product.getStock() < item.getQuantity()) {
                throw new RuntimeException("Stok yetersiz: " + product.getName());
            }
        }

        // Sipariş oluştur
        Order order = new Order();
        order.setId(orderId);
        order.setCustomerId(customerId);

        double total = 0;
        for (OrderItem item : items) {
            Product product = productRepository.findById(item.getProductId());

            // Stok azalt
            product.setStock(product.getStock() - item.getQuantity());
            productRepository.add(product);

            // Fiyat hesapla
            double price = product.getPrice() * item.getQuantity();
            item.setPrice(price);
            total += price;
        }

        order.setOrderItemList(items);
        order.setTotalPrice(total);
        orderRepository.add(order);

        return order;
    }

    @Override
    public Order findOrderById(int id) {
        return orderRepository.findById(id);
    }

    @Override
    public List<Order> getCustomerOrders(int customerId) {
        List<Order> customerOrders = new ArrayList<>();
        List<Order> allOrders = orderRepository.findAll();

        for (Order order : allOrders) {
            if (order.getCustomerId() == customerId) {
                customerOrders.add(order);
            }
        }
        return customerOrders;
    }

    @Override
    public void displayOrderDetails(int orderId) {
        Order order = orderRepository.findById(orderId);
        if (order == null) {
            System.out.println("Sipariş bulunamadı");
            return;
        }

        Customer customer = customerRepository.findById(order.getCustomerId());

        System.out.println("=== Sipariş Detayları ===");
        System.out.println("ID: " + order.getId());
        System.out.println("Müşteri: " + (customer != null ? customer.getName() : "Bilinmeyen"));
        System.out.println("Toplam: " + order.getTotalPrice() + " TL");
        System.out.println("Ürünler:");

        for (OrderItem item : order.getOrderItemList()) {
            Product product = productRepository.findById(item.getProductId());
            String productName = product != null ? product.getName() : "Bilinmeyen";
            System.out.println("- " + productName + " x" + item.getQuantity() + " = " + item.getPrice() + " TL");
        }
    }

    @Override
    public void displayOrderStatistics() {
        List<Order> allOrders = orderRepository.findAll();

        if (allOrders.isEmpty()) {
            System.out.println("Henüz sipariş yok");
            return;
        }

        int totalOrders = allOrders.size();
        double totalRevenue = 0;

        for (Order order : allOrders) {
            totalRevenue += order.getTotalPrice();
        }

        System.out.println("=== Sipariş İstatistikleri ===");
        System.out.println("Toplam Sipariş: " + totalOrders);
        System.out.println("Toplam Gelir: " + totalRevenue + " TL");
        System.out.println("Ortalama Sipariş: " + (totalRevenue / totalOrders) + " TL");
    }
}