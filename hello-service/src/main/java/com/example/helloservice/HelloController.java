package com.example.helloservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelloController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${counter.service.url}")
    private String counterServiceUrl;

    @Value("${hello.message}")
    private String helloMessageTemplate;

    @GetMapping("/hello")
    public String hello() {
        // Call the counter-service to increment the count
        ResponseEntity<Long> response = restTemplate.postForEntity(counterServiceUrl, null, Long.class);
        Long count = response.getBody();
        return String.format(helloMessageTemplate, count);
    }
}
