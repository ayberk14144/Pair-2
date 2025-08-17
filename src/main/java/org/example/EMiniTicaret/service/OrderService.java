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

    public void createOrder(int customerId, List<OrderItem> items, int orderId) {
        System.out.println("🛒 Sipariş oluşturuluyor...");

        // 1. Müşteri kontrolü
        Customer customer = customerRepository.findById(customerId);
        if (customer == null) {
            System.out.println(" Müşteri bulunamadı: " + customerId);
            return;
        }

        // 2. Sipariş boş mu kontrolü
        if (items == null || items.isEmpty()) {
            System.out.println(" Sipariş boş olamaz");
            return;
        }

        // 3. Önce tüm ürünlerin stok kontrolünü yap
        System.out.println("🔍 Stok kontrolü yapılıyor...");
        for (OrderItem item : items) {
            if (item.getQuantity() <= 0) {
                System.out.println(" Hata: Geçersiz miktar: " + item.getQuantity());
                return;
            }

            Product product = productRepository.findById(item.getProductId());
            if (product == null) {
                System.out.println(" Ürün bulunamadı: " + item.getProductId());
                return;
            }

            if (product.getStock() < item.getQuantity()) {
                System.out.println(" Stok yetersiz! Ürün: " + product.getName() +
                        ", Mevcut: " + product.getStock() +
                        ", İstenen: " + item.getQuantity());
                return;
            }
        }

        // 4. Sipariş oluştur (kontroller başarılı ise)
        Order order = new Order();
        order.setId(orderId);
        order.setCustomerId(customerId);

        double total = 0.0;
        List<OrderItem> validItems = new ArrayList<>();

        // 5. Stokları güncelle ve sipariş kalemlerini hazırla
        System.out.println("📝 Sipariş kalemleri işleniyor...");
        for (OrderItem item : items) {
            Product product = productRepository.findById(item.getProductId());

            // Stoku azalt
            product.setStock(product.getStock() - item.getQuantity());
            productRepository.add(product);

            // Fiyat hesapla
            double price = product.getPrice() * item.getQuantity();
            item.setPrice(price);

            // Sipariş kalemine ekle
            validItems.add(item);
            total += price;

            System.out.println("  ✓ " + product.getName() + " x " + item.getQuantity() +
                    " = " + price + " TL (Kalan stok: " + product.getStock() + ")");
        }

        // 6. Sipariş bilgilerini set et
        order.setOrderItemList(validItems);
        order.setTotalPrice(total);

        // 7. Siparişi kaydet
        orderRepository.add(order);

        // 8. Başarı mesajı
        System.out.println(" Sipariş başarıyla oluşturuldu!");
        System.out.println(" Sipariş ID: " + orderId);
        System.out.println(" Müşteri: " + customer.getName());
        System.out.println(" Toplam: " + order.getTotalPrice() + " TL");
        System.out.println(" Sipariş tamamlandı!\n");
    }

    @Override
    public Order createOrder(String orderId, String customerId, List<OrderItem> items) {
        return null;
    }

    @Override
    public Order findOrderById(String id) {
        return null;
    }

    @Override
    public List<Order> getCustomerOrders(String customerId) {
        return List.of();
    }

    @Override
    public void displayOrderDetails(String orderId) {

    }

    @Override
    public void displayOrderStatistics() {

    }
}
