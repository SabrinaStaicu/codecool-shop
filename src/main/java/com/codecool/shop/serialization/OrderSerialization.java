package com.codecool.shop.serialization;

import com.codecool.shop.model.Order;
import com.codecool.shop.model.Product;
import com.google.gson.*;
import com.google.gson.stream.JsonReader;

import java.lang.reflect.Type;
import java.util.List;

public class OrderSerialization {


    public JsonElement serialize(Order order) {
        JsonObject result = new JsonObject();
        result.addProperty("id", order.getId());
        result.addProperty("name", order.getName());
        result.addProperty("email", order.getEmail());
        result.addProperty("phoneNumber", order.getPhoneNumber());
        result.addProperty("address", order.getAddress());
        result.addProperty("city", order.getCity());
        result.addProperty("state", order.getState());
        result.addProperty("zip", order.getZip());
        result.addProperty("cardHolderName", order.getCardHolderName());
        result.addProperty("cardNumber", order.getCardNumber());
        result.addProperty("cardExpirationDate", order.getCardExpirationDate());
        result.addProperty("cardCVV", order.getCardCVV());

        List<Product> products = order.getProducts();
        JsonObject jsonObject;
        JsonParser parser = new JsonParser();
        JsonArray jsonArray = new JsonArray();
        for (Product product : products) {
            jsonObject = (JsonObject) parser.parse(product.toString());
            jsonArray.add(jsonObject);
        }
        result.add("products", jsonArray);
        return result;

    }
}
