package com.store.service;

import com.store.db.Database;
import com.store.model.Product;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    public synchronized boolean buyProduct(int id, int qty) {

        try {
            Thread.sleep(100);
        } catch (Exception ignored) {}

        Product p = Database.products.get(id);

        if (p.stock < qty) return false;

        p.stock -= qty;

        if (p.stock == 0) {
            System.out.println("SOLD OUT: " + p.name);
        }

        return true;
    }
}