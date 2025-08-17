package org.example.EMiniTicaret.service;

import org.example.EMiniTicaret.entities.*;
import org.example.EMiniTicaret.repository.*;


import java.util.ArrayList;
import java.util.List;

public class OrderService {
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

    public void createOrder(int customerId, List<OrderItem> items, int orderId) {
        Customer customer = customerRepository.findById(customerId);
        if (customer == null) {
            System.out.println("Müşteri bulunamadı.");
            return;
        }
        double total = 0.0;
        List<Product> products= new ArrayList<>();
        List<OrderItem> validItems= new ArrayList<>();
        for (OrderItem item : items) {
            Product product = productRepository.findById(item.getProductId());
            if (product == null || product.getStock() < item.getQuantity()) {
                System.out.println("Ürün yok veya stok yetersiz: " + item.getProductId());
                continue;
            }
            product.setStock(product.getStock() - item.getQuantity());
            productRepository.add(product);

            double price = product.getPrice() * item.getQuantity();
            item.setPrice(price);

            order.getItems().add(item);
            total += price;
        }

        order.setTotalPrice(total);
        orderRepository.add(order);

        System.out.println("Sipariş oluşturuldu. Toplam: " + order.getTotalPrice() + "₺");
    }
}
