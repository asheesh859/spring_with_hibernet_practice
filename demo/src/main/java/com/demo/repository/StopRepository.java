package com.demo.repository;

import com.demo.entity.Stops;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StopRepository extends JpaRepository<Stops , Integer> {
}
