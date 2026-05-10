package com.order_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final RestTemplate restTemplate = new RestTemplate();

    @GetMapping
    public String placeOrder() {

        String payment = restTemplate.getForObject(
                "http://payment:8082/payment", String.class);

        String inventory = restTemplate.getForObject(
                "http://inventory:8083/inventory", String.class);

        return "Order Success -> " + payment + " | " + inventory;
    }
}
