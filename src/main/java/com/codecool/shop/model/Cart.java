package com.codecool.shop.model;

import java.util.ArrayList;
import java.util.List;

public class Cart extends BaseModel{
    private List<Product> products;

    public Cart() {
        this.products = new ArrayList<>();
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public List<Product> getProducts() {
        return this.products;
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }

    public void deleteProduct(int id) {
        this.products.removeIf(product -> product.id == id);
    }

    @Override
    public String toString() {
        StringBuilder productsList = new StringBuilder();
        for (Product product : this.products) {
            productsList.append(product.name).append(", ");
        }
        return productsList.toString();
    }
}
