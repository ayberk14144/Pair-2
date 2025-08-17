package org.example.app.repository;

import org.example.app.entities.Product;
i

import java.util.List;

public class ProductRepository implements BaseRepository<Product> {
    @Override
    public List<Product> findAll() {
        return List.of();
    }

    @Override
    public Product findById(int id) {
        return null;
    }

    @Override
    public void save(Product product) {

    }

    @Override
    public void save(Product product) {

    }
}
