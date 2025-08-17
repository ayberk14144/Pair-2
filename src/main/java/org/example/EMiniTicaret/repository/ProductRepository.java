package org.example.EMiniTicaret.repository;

import org.example.EMiniTicaret.entities.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IRepository<Product> {
    private List<Product> products = new ArrayList<>();

    @Override
    public void add(Product entity) {
        products.add(entity);
    }

    @Override
    public void remove(int id) {
        products.removeIf(p -> p.getId() == id);
    }

    @Override
    public Product findById(int id) {
        return products.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Product> findAll() {
        return products;
    }
}
