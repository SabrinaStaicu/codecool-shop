package com.codecool.shop.controller;

import com.codecool.shop.config.TemplateEngineUtil;
import com.codecool.shop.dao.OrderDao;
import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.implementation.OrderDaoMem;
import com.codecool.shop.dao.implementation.ProductCategoryDaoMem;
import com.codecool.shop.dao.implementation.ProductDaoMem;
import com.codecool.shop.model.Cart;
import com.codecool.shop.model.Order;
import com.codecool.shop.service.ProductService;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

@WebServlet(urlPatterns = {"/order_confirmation"})
public class OrderConfirmation extends HttpServlet {
    OrderDao orderDao = OrderDaoMem.getInstance();
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductDao productDataStore = ProductDaoMem.getInstance();
        ProductCategoryDao productCategoryDataStore = ProductCategoryDaoMem.getInstance();

        Order order = CheckoutController.getCurrentOrder();
        TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(req.getServletContext());
        WebContext context = new WebContext(req, resp, req.getServletContext());
        context.setVariable("products", order.getProducts());
        context.setVariable("cartPriceSum", CartController.getCartProductsPriceSum());
        context.setVariable("billingAddress", order.getStringAddress());
        context.setVariable("cart", CartController.getCartProducts());
        context.setVariable("cardNumber", order.getCardNumber());
        orderDao.add(order);
        orderDao.storeOrderInJson(order);
//        String userEmail = order.getEmail();
//        String shopEmail = "codecool_shop@gmail.com";
//        String host = "localhost";
//        Properties properties = System.getProperties();
//        properties.setProperty("mail.smtp.host", host);
//        Session session = Session.getDefaultInstance(properties);
        clearShoppingSession();
        // // Alternative setting of the template context
        // Map<String, Object> params = new HashMap<>();
        // params.put("category", productCategoryDataStore.find(1));
        // params.put("products", productDataStore.getBy(productCategoryDataStore.find(1)));
        // context.setVariables(params);
        engine.process("fragment/order_confirmation.html", context, resp.getWriter());
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req.getParameter("card_holder_name"));
        CheckoutController.getCurrentOrder().setCardPaymentCredentials(req.getParameter("card_holder_name"),
                req.getParameter("card_number"),
                req.getParameter("card_expiration_date"),
                req.getParameter("cvv"));

        CheckoutController.getCurrentOrder().setProducts(CartController.getCartProducts());
//        System.out.println(CartController.getCartProducts());
        resp.sendRedirect("/order_confirmation");
    }

    private void clearShoppingSession() {
        CartController.cart = new Cart();
        CheckoutController.order = new Order();
    }
}
