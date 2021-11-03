package com.codecool.shop.config;

import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.SupplierDao;
import com.codecool.shop.dao.implementation.ProductCategoryDaoMem;
import com.codecool.shop.dao.implementation.ProductDaoMem;
import com.codecool.shop.dao.implementation.SupplierDaoMem;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.Supplier;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class Initializer implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ProductDao productDataStore = ProductDaoMem.getInstance();
        ProductCategoryDao productCategoryDataStore = ProductCategoryDaoMem.getInstance();
        SupplierDao supplierDataStore = SupplierDaoMem.getInstance();
//        ProductSupplierDao productSupplierDataStore = ProductSupplierDaoMem.getInstance();

        //setting up a new supplier
        Supplier amazon = new Supplier("Amazon", "Digital content and services");
        supplierDataStore.add(amazon);
        Supplier samsung = new Supplier("Samsung", "Diverse electronics");
        supplierDataStore.add(samsung);
        Supplier lenovo = new Supplier("Lenovo", "Computers");
        supplierDataStore.add(lenovo);

        //setting up a new product category
        ProductCategory tablet = new ProductCategory("Tablet", "Hardware", "A tablet computer, commonly shortened to tablet, is a thin, flat mobile computer with a touchscreen display.");
        productCategoryDataStore.add(tablet);
        ProductCategory mobilePhone = new ProductCategory("Mobile Phones", "Hardware", "A phone is thin, flat part of your heart that is very easy to drop in the toilet");
        productCategoryDataStore.add(mobilePhone);
        ProductCategory laptop = new ProductCategory("Laptops", "Hardware", "Another thing that can drop in the toilet");
        productCategoryDataStore.add(laptop);

        //setting up products and printing it
        productDataStore.add(new Product("Amazon Fire", 49.9f, "USD", "Fantastic price. Large content ecosystem. Good parental controls. Helpful technical support.", tablet, amazon));
        productDataStore.add(new Product("Lenovo IdeaPad Miix 700", 479, "USD", "Keyboard cover is included. Fanless Core m5 processor. Full-size USB ports. Adjustable kickstand.", tablet, lenovo));
        productDataStore.add(new Product("Amazon Fire HD 8", 89, "USD", "Amazon's latest Fire HD 8 tablet is a great value for media consumption.", tablet, amazon));
        productDataStore.add(new Product("Samsung Galaxy A8", 300, "USD", "Samsung's Samsung Galaxy A8 phone is a great value for media consumption.", mobilePhone, samsung));
        productDataStore.add(new Product("Galaxy X Fold 2", 1799, "USD", "Samsung Galaxy Z Fold 2 mobile was launched on 1st September 2020.", mobilePhone, samsung));
        productDataStore.add(new Product("Nokia 3.5 5G", 599, "USD", "Elevate your photos and videos to pro level with ease.", mobilePhone, amazon));
        productDataStore.add(new Product("Lenovo ThinkPad X1 Yoga", 1089, "USD", "LATM", laptop, lenovo));

    }
}
