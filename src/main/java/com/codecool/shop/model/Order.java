package com.codecool.shop.model;

import java.util.ArrayList;
import java.util.List;

public class Order extends BaseModel{
    private String email;
    private String phoneNumber;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String cardHolderName;
    private String cardNumber;
    private String cardExpirationDate;
    private String cardCVV;
    private List<Product> products;


    public Order() {
        super();
    }

    public void setDetails(String name,String email,String phoneNumber,String address,String city, String state, String zip) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    public void setCardPaymentCredentials(String cardHolderName,String cardNumber,String cardExpirationDate,String cardCVV) {
        this.cardHolderName = cardHolderName;
        this.cardNumber = cardNumber;
        this.cardExpirationDate = cardExpirationDate;
        this.cardCVV = cardCVV;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

//    @Override
//    public String toString() {
//        return String.format("id: %1$d, " +
//                        "name: %2$s, " +
//                        "email: %3$f, " +
//                        "address: %4$s, " +
//                        "city: %5$s, " +
//                        "state: %6$s, " +
//                        "zip: %7$f, " +
//                        "cardHolderName: %8$s, " +
//                        "cardNumber: %9$s, " +
//                        "cardExpirationDate: %10$s, " +
//
//                this.id,
//                this.name,
//                this.defaultPrice,
//                this.defaultCurrency.toString(),
//                this.productCategory.getName(),
//                this.supplier.getName());
//    }

    public String getStringAddress() {
        return this.city + ", " + this.state + ", " + this.address + ", " + this.zip;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZip() {
        return zip;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public String getCardExpirationDate() {
        return cardExpirationDate;
    }

    public String getCardCVV() {
        return cardCVV;
    }
}
