package org.example.EMiniTicaret.service;

import org.example.EMiniTicaret.entities.Product;
import org.example.EMiniTicaret.repository.*;

import java.util.List;

import java.awt.*;

public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product addProduct(Product p) {
        if (p == null) throw new IllegalArgumentException("Product cannot be null");
        if (p.getName() == null || p.getName().isBlank()) throw new IllegalArgumentException("Name is required");
        if (p.getPrice() < 0) throw new IllegalArgumentException("Price cannot be negative");
        if (p.getStock() < 0) throw new IllegalArgumentException("Stock cannot be negative");
        productRepository.add(p);
        return p;
    }

    public boolean hasStock(int productId, int qty) {
        Product p = productRepository.findById(productId);
        return p != null && p.getStock() >= qty;
    }

    public void decreaseStock(int productId, int qty) { /* … */ }

    public void increaseStock(int productId, int qty) { /* … */ }

    public Product findById(int id) {
        return productRepository.findById(id);
    }

    public void listAll() {

        List<Product> products = productRepository.findAll();
        return ;
    }
    }
