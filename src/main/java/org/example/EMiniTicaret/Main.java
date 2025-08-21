package org.example.EMiniTicaret;
import org.example.EMiniTicaret.entities.Customer;
import org.example.EMiniTicaret.entities.Order;
import org.example.EMiniTicaret.entities.OrderItem;
import org.example.EMiniTicaret.entities.Product;
import org.example.EMiniTicaret.repository.CustomerRepository;
import org.example.EMiniTicaret.repository.OrderRepository;
import org.example.EMiniTicaret.repository.ProductRepository;
import org.example.EMiniTicaret.service.CustomerService;
import org.example.EMiniTicaret.service.OrderService;
import org.example.EMiniTicaret.service.ProductService;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Repositories
        CustomerRepository customerRepository = new CustomerRepository();
        ProductRepository productRepository = new ProductRepository();
        OrderRepository orderRepository = new OrderRepository();

        // Services
        CustomerService customerService = new CustomerService(customerRepository);
        ProductService productService = new ProductService(productRepository);
        OrderService orderService = new OrderService(orderRepository, productService, customerService);

        // Müşteri ve ürün ekleme
        System.out.println("### Müşteri ve Ürün Ekleme ###");
        Customer customer1 = new Customer(1, "Ahmet Yılmaz", "ahmet.yilmaz@example.com", "5551234567");
        customerService.addCustomer(customer1);


        Product product1 = new Product(101, "Laptop", 15000.0, 50);
        Product product2 = new Product(102, "Mouse", 250.0, 200);
        Product product3 = new Product(103, "Klavye", 450.0, 150);

        productService.addProduct(product1);
        productService.addProduct(product2);
        productService.addProduct(product3);

        // Ürünleri listeleme
        System.out.println("\n### Ürün Listesi ###");
        productService.listAll();

        // Sipariş oluşturma
        System.out.println("\n### Sipariş Oluşturma ###");
        List<OrderItem> orderItems = new ArrayList<>();
        orderItems.add(new OrderItem(1, 101, 1));
        orderItems.add(new OrderItem(2, 102, 2));

        try {
            Order newOrder = orderService.createOrder(1, customer1.getId(), orderItems);
            System.out.println("Sipariş başarıyla oluşturuldu. Sipariş ID: " + newOrder.getId());
        } catch (RuntimeException e) {
            System.out.println("Sipariş oluşturulamadı: " + e.getMessage());
        }

        // Sipariş detaylarını görüntüleme
        System.out.println("\n### Sipariş Detayları ###");
        orderService.displayOrderDetails(1);

        // Sipariş istatistikleri
        System.out.println("\n### Sipariş İstatistikleri ###");
        orderService.displayOrderStatistics();

        // Stok kontrolü ve güncelleme
        System.out.println("\n### Stok Kontrol ve Güncelleme ###");
        int productIdToCheck = 101;
        int qtyToBuy = 2;
        boolean hasStock = productService.hasStock(productIdToCheck, qtyToBuy);
        System.out.println("Ürün " + productIdToCheck + " için " + qtyToBuy + " adet stok var mı? " + (hasStock ? "Evet" : "Hayır"));

        productService.decreaseStock(productIdToCheck, 1); // Azaltma metodu çağrısı

        // Eksik bir ürün eklemeye çalışmak
        System.out.println("\n### Hatalı Ürün Ekleme Örneği ###");
        try {
            Product invalidProduct = new Product();
            productService.addProduct(invalidProduct);
        } catch (IllegalArgumentException e) {
            System.out.println("Hata yakalandı: " + e.getMessage());
        }
    }
}