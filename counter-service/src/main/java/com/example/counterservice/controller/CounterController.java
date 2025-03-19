package com.example.counterservice.controller;

import com.example.counterservice.service.CallCounterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/counter")
public class CounterController {
    @Autowired
    private CallCounterService service;

    @PostMapping("/increment")
    public ResponseEntity<Long> increment() {
        Long newCount = service.incrementCount();
        return ResponseEntity.ok(newCount);
    }
}
