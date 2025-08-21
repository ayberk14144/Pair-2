package org.example.EMiniTicaret.repository;

import org.example.EMiniTicaret.entities.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IRepository<Product> {
    List<Product> products = new ArrayList<Product>();

    @Override
    public void add(Product product) {
        products.add(product);
    }

    @Override
    public void remove(int id) {
        Product productRemove = products.stream().filter(product -> product.getId() == id).findFirst().orElse(null);
        if (productRemove == null) {
            System.out.println(id + "li bir ürün yok.");
            return;
        }
        products.remove(productRemove);
        System.out.println(id + "'li ürün silindi.");

    }
    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public Product findById(int id) {
        return products.stream().filter(product -> product.getId() == id).findFirst().orElse(null);
    }

    public int stockQuantity(int id) {
        Product product1 = products.stream().filter(product -> product.getId() == id).findFirst().orElse(null);
        assert product1 != null;
        return product1.getStock();
    }
}
