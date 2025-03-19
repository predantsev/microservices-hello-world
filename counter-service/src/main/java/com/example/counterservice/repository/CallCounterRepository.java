package com.example.counterservice.repository;

import com.example.counterservice.entity.CallCounter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CallCounterRepository extends JpaRepository<CallCounter, Long> {
}
