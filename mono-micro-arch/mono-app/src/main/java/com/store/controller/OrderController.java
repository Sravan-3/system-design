package com.store.controller;

import com.store.service.ProductService;
import org.springframework.web.bind.annotation.*;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class OrderController {

    private final ProductService productService;

    public OrderController(ProductService productService) {
        this.productService = productService;
    }

    private static final AtomicInteger counter = new AtomicInteger(0);

    @GetMapping("/order")
    public String order(
            @RequestParam int productId,
            @RequestParam int qty) {

        int count = counter.incrementAndGet();

        if (count % 100 == 0) {
            System.out.println("🔥 Requests processed: " + count);
        }

        productService.buyProduct(productId, qty);

        return "OK";
    }
}