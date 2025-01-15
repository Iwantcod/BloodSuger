package com.example.demo.Repository;

import com.example.demo.Entity.Plans;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlansRepository extends JpaRepository<Plans, Integer> {
}
