package org.example.EMiniTicaret.service;

import org.example.EMiniTicaret.entities.Product;

public interface IProductService {
    void addProduct(Product p);
    boolean hasStock(int productId, int qty);
    void decreaseStock(int productId, int qty);
    void increaseStock(int productId, int qty);
    public Product findById(int id);

}
