package com.codecool.shop.controller;


import com.codecool.shop.dao.CartDao;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.SupplierDao;
import com.codecool.shop.dao.implementation.CartDaoMem;
import com.codecool.shop.dao.implementation.ProductDaoMem;
import com.codecool.shop.dao.implementation.SupplierDaoMem;
import com.codecool.shop.model.Cart;
import com.codecool.shop.model.Product;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(urlPatterns = {"/add_to_cart"})
public class CartController extends HttpServlet {
    ProductDao productDataStore = ProductDaoMem.getInstance();
    CartDao cartDao = CartDaoMem.getInstance();
    static Cart cart = new Cart();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

        @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(readPageURL(req));
//        cart.addProduct(productDataStore.find(Integer.parseInt(readPageURL(req).get("item_id"))));
//        System.out.println(cart.toString());
        if (readPageURL(req).get("delete") != null) {
            cart.deleteProduct(productDataStore.find(Integer.parseInt(readPageURL(req).get("item_id"))).getId());
        } else {
            cart.addProduct(productDataStore.find(Integer.parseInt(readPageURL(req).get("item_id"))));
            System.out.println(cart.toString());
        }

    }

    public HashMap<String, String> readPageURL(HttpServletRequest request) {
//        String categoryId = request.getParameter("category");
//        System.out.println(request.getParameter("item_id"));
        HashMap<String, String> paramList = new HashMap<>();
        paramList.put("item_id", request.getParameter("item_id"));
        paramList.put("delete", request.getParameter("delete"));
//        return Integer.parseInt(request.getParameter("item_id"));
        return paramList;
    }

    public static List<Product> getCartProducts() {
        return cart.getProducts();
    }

    public static double getCartProductsPriceSum() {
        double sum = 0;
        for (Product product : getCartProducts()) {
            StringBuilder price = new StringBuilder();
            for (char dig: product.getPrice().toCharArray()) {
                if (Character.isDigit(dig) || String.valueOf(dig).equals(".")) {
                    price.append(dig);
                }
            }
            sum = sum + Double.parseDouble(price.toString());
        }
        return sum;
    }

}
