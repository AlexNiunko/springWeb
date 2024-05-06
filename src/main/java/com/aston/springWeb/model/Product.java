package com.aston.springWeb.model;

import java.util.List;

public class Product {
    private long id;
    private String productName;
    private double productPrice;
    private int amount;
    private ProductDescription description;
    private List<User> buyers;
    private List<Sale> orders;
}
