package com.store.db;

import com.store.model.Product;
import java.util.*;

public class Database {

    public static Map<Integer, Product> products = new HashMap<>();

    static {
        products.put(1, new Product(1, "CPU", 20000, 10000));
        products.put(2, new Product(2, "GPU", 50000, 15000));
        products.put(3, new Product(3, "RAM", 8000, 8000));
    }
}