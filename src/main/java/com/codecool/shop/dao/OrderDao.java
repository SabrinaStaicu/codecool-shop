package com.codecool.shop.dao;

import com.codecool.shop.model.Order;

import java.io.IOException;
import java.util.List;

public interface OrderDao {
    void add(Order order);
    Order find(int id);
    void remove(int id);
    void storeOrderInJson(Order order) throws IOException;

    List<Order> getAll();
}
