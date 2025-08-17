package org.example.EMiniTicaret.entities;

public class OrderItem
{
    // Alanlar
    private int productId;   // Hangi ürün
    private int quantity;    // Kaç adet
    private double price;    // Ürünün sipariş anındaki fiyatı

    // Parametresiz constructor
    public OrderItem() {
    }

    // Parametreli constructor
    public OrderItem(int productId, int quantity, double price) {
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
    }

    // Getter - Setter metotları
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
