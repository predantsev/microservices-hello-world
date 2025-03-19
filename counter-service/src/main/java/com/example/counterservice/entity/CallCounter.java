package com.example.counterservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "call_counter")
public class CallCounter {
    @Id
    private Long id = 1L;  // using a fixed id since there is only one counter

    private Long count = 0L;

    public Long getId() {
        return id;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
