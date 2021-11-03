package com.codecool.shop;

import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.SupplierDao;
import com.codecool.shop.dao.implementation.ProductCategoryDaoMem;
import com.codecool.shop.dao.implementation.ProductDaoMem;
import com.codecool.shop.dao.implementation.SupplierDaoMem;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.Supplier;
import com.codecool.shop.service.ProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Mockito.*;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit.*;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceTest {

    @Mock private ProductDaoMem productDao;
    @Mock private ProductCategoryDaoMem productCategoryDao;
    @Mock private SupplierDao supplierDao;
    private List<Product> productsBySupplierAmazon;
    private List<Product> productsByCategoryLaptop;

    @BeforeEach
    public void initMocks() {
        productDao = Mockito.mock(ProductDaoMem.class);
        productCategoryDao = Mockito.mock(ProductCategoryDaoMem.class);
        supplierDao = Mockito.mock(SupplierDaoMem.class);
        MockitoAnnotations.initMocks(this);

//        //setting up a new supplier
        //id1
        Supplier amazon = new Supplier("Amazon", "Digital content and services");
//        supplierDao.add(amazon);
        //id2
        Supplier samsung = new Supplier("Samsung", "Diverse electronics");
//        supplierDao.add(samsung);
        //id3
        Supplier lenovo = new Supplier("Lenovo", "Computers");
//        supplierDao.add(lenovo);
//
//        //setting up a new product category
//        //id1
        ProductCategory tablet = new ProductCategory("Tablet", "Hardware", "Tablet test description");
//        productCategoryDao.add(tablet);
//        //id2
        ProductCategory mobilePhone = new ProductCategory("Mobile Phones", "Hardware", "Mobile test definition");
//        productCategoryDao.add(mobilePhone);
//        //id3
        ProductCategory laptop = new ProductCategory("Laptops", "Hardware", "Laptops test definition");
//        productCategoryDao.add(laptop);
//
//        //setting up products and printing it
//        productDao.add(new Product("Amazon Fire", 49.9f, "USD", "Amazon Fire description", tablet, amazon));
//        productDao.add(new Product("Lenovo IdeaPad Miix 700", 479, "USD", "Lenovo Idea Miix 700 description", tablet, lenovo));
//        productDao.add(new Product("Amazon Fire HD 8", 89, "USD", "Amazon Fire HD 8 description", tablet, amazon));
//        productDao.add(new Product("Samsung Galaxy A8", 300, "USD", "Samsung Galaxy A8 description", mobilePhone, samsung));
//        productDao.add(new Product("Galaxy X Fold 2", 1799, "USD", "Samsung Galaxy Z Fold 2 description", mobilePhone, samsung));
//        productDao.add(new Product("Nokia 3.5 5G", 599, "USD", "Nokia 3.5G description", mobilePhone, amazon));
//        productDao.add(new Product("Lenovo ThinkPad X1 Yoga", 1089, "USD", "LATM", laptop, lenovo));

        //setting up testing products lists
        productsBySupplierAmazon = new ArrayList<>();
        productsByCategoryLaptop = new ArrayList<>();
            //Supplier "Amazon" products
        productsBySupplierAmazon.add(new Product("Amazon Fire", 49.9f, "USD", "Amazon Fire description", tablet, amazon));
        productsBySupplierAmazon.add(new Product("Amazon Fire HD 8", 89, "USD", "Amazon Fire HD 8 description", tablet, amazon));
        productsBySupplierAmazon.add(new Product("Nokia 3.5 5G", 599, "USD", "Nokia 3.5G description", mobilePhone, amazon));

            //Category "Laptop" products
        productsByCategoryLaptop.add(new Product("Lenovo ThinkPad X1 Yoga", 1089, "USD", "LATM", laptop, lenovo));

    }

    //Testing Category methods

    @Test
    public void getProductCategory_existentCategoryId_returnsCategory() {
        ProductService productService = new ProductService(productDao, productCategoryDao);
        Mockito.when(productCategoryDao.find(3)).thenReturn(new ProductCategory("Laptops", "Hardware", "Laptops test definition"));
        Assertions.assertEquals("Laptops", productService.getProductCategory(3).getName());
    }

    @Test
    public void getProductCategory_nonexistentCategoryId_returnNull() {
        ProductService productService = new ProductService(productDao, productCategoryDao);
        Mockito.when(productCategoryDao.find(4)).thenReturn(null);
        Assertions.assertNull(productService.getProductCategory(4));
    }

    @Test
    public void getProductsForCategory_existentCategoryId_returnsProducts() {
        ProductService productService = new ProductService(productDao, productCategoryDao);
        ProductCategory productCategory = new ProductCategory("Laptops", "Hardware", "Laptops test definition");
        Mockito.when(productCategoryDao.find(3)).thenReturn(productCategory);
        Mockito.when(productDao.getBy(productCategory)).thenReturn(productsByCategoryLaptop);
        Assertions.assertEquals(productsByCategoryLaptop, productService.getProductsForCategory(3));
    }

    @Test
    public void getProductsForCategory_nonexistentCategoryId_returnNull() {
        List<Product> products = new ArrayList<>();
        ProductService productService = new ProductService(productDao, productCategoryDao);
        Mockito.when(productCategoryDao.find(4)).thenReturn(null);
        Mockito.when(productDao.getBy((ProductCategory) null)).thenReturn(products);
        Assertions.assertEquals(products.size(), productService.getProductsForCategory(4).size());
    }

    //Testing Supplier methods from here

    @Test
    public void getProductSupplier_existentSupplierId_returnsSupplier() {
        ProductService productService = new ProductService(productDao, supplierDao);
        Mockito.when(supplierDao.find(3)).thenReturn(new Supplier("Lenovo", "Computers"));
        Assertions.assertEquals("Lenovo", productService.getProductSupplier(3).getName());
    }

    @Test
    public void getProductSupplier_nonexistentSupplierId_returnNull() {
        ProductService productService = new ProductService(productDao, supplierDao);
        Mockito.when(supplierDao.find(4)).thenReturn(null);
        Assertions.assertNull(productService.getProductSupplier(4));
    }

    @Test
    public void getProductsForSupplier_existentSupplierId_returnsProducts() {
        ProductService productService = new ProductService(productDao, supplierDao);
        Supplier supplier = new Supplier("Amazon", "Digital content and services");
        Mockito.when(supplierDao.find(1)).thenReturn(supplier);
        Mockito.when(productDao.getBy(supplier)).thenReturn(productsBySupplierAmazon);
        Assertions.assertEquals(productsBySupplierAmazon, productService.getProductsForSupplier(1));
    }

    @Test
    public void getProductsForSupplier_nonexistentSupplierId_returnNull() {
        List<Product> products = new ArrayList<>();
        ProductService productService = new ProductService(productDao, supplierDao);
        Mockito.when(supplierDao.find(4)).thenReturn(null);
        Mockito.when(productDao.getBy((Supplier) null)).thenReturn(products);
        Assertions.assertEquals(products.size(), productService.getProductsForSupplier(4).size());
    }

}
