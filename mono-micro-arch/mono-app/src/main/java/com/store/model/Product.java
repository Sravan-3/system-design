package com.store.model;

public class Product {
    public int id;
    public String name;
    public int price;
    public int stock;

    public Product(int id, String name, int price, int stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }
}