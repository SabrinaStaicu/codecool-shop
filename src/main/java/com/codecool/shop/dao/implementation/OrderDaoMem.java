package com.codecool.shop.dao.implementation;

import com.codecool.shop.dao.OrderDao;
import com.codecool.shop.model.Order;
import com.codecool.shop.serialization.OrderSerialization;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderDaoMem implements OrderDao {

    private List<Order> data = new ArrayList<>();
    private static OrderDaoMem instance = null;
    private Gson gson = new Gson();
    private DateFormat dateFormat = new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss");
    private OrderSerialization orderSerialization = new OrderSerialization();

    /* A private Constructor prevents any other class from instantiating.
     */
    private OrderDaoMem() {
    }

    public static OrderDaoMem getInstance() {
        if (instance == null) {
            instance = new OrderDaoMem();
        }
        return instance;
    }

    @Override
    public void add(Order order) {
        order.setId(data.size() + 1);
        data.add(order);
    }

    @Override
    public Order find(int id) {
        return data.stream().filter(t -> t.getId() == id).findFirst().orElse(null);
    }

    @Override
    public void remove(int id) {
        data.remove(find(id));
    }

    @Override
    public void storeOrderInJson(Order order) throws IOException {
//        Date date = new Date();
//        String baseRoute = "src/main/java/com/codecool/shop/adminlog";
//        File file = new File(baseRoute + "/order_"+ order.getId() + "_date_" + dateFormat.format(date) +".json");
//        if (file.createNewFile()) {
//            String filePath = baseRoute + "/order_"+ order.getId() + "_date_" + dateFormat.format(date) +".json";
//            FileWriter fileWriter = new FileWriter(filePath);
//            gson.toJson(order, fileWriter);
//        }

        Date date = new Date();
        String baseRoute = "src/main/java/com/codecool/shop/adminlog";
        File file = new File(baseRoute + "/order_"+ order.getId() + "_date_" + dateFormat.format(date) +".json");
        if (file.createNewFile()) {
            String filePath = baseRoute + "/order_"+ order.getId() + "_date_" + dateFormat.format(date) +".json";
            FileWriter fileWriter = new FileWriter(filePath);
            JsonObject jsonObject = (JsonObject) orderSerialization.serialize(order);
//            System.out.println(jsonObject.toString());
            fileWriter.write(jsonObject.toString());
            fileWriter.close();
//            gson.toJson(orderSerialization.serialize(order), fileWriter);
        }
    }

    @Override
    public List<Order> getAll() {
        return data;
    }
}
