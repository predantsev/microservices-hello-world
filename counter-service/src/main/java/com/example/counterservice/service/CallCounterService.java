package com.example.counterservice.service;

import com.example.counterservice.entity.CallCounter;
import com.example.counterservice.repository.CallCounterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CallCounterService {
    @Autowired
    private CallCounterRepository repository;

    public synchronized Long incrementCount() {
        CallCounter counter = repository.findById(1L).orElse(new CallCounter());
        counter.setCount(counter.getCount() + 1);
        repository.save(counter);
        return counter.getCount();
    }
}
