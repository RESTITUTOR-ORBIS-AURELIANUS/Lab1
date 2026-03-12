package com.quantdev.lab1.controller;

import com.quantdev.lab1.entity.Counter;
import com.quantdev.lab1.service.CounterService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/counter")
@CrossOrigin(origins = "http://localhost:5173")
public class CounterController {
    private final CounterService counterService;

    public CounterController(CounterService counterService) {
        this.counterService = counterService;
    }

    @GetMapping
    public Counter getCounter() {
        int count = counterService.getCount();
        return new Counter(count);
    }

    @PostMapping("/increment")
    public Counter incrementCounter() {
        int count = counterService.incrementAndGetCount();
        return new Counter(count);
    }
}
