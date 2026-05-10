package com.inventory_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    @GetMapping
    public String inventory() {
        try { Thread.sleep(200); } catch (Exception e) {}
        return "Stock Reserved";
    }
}
