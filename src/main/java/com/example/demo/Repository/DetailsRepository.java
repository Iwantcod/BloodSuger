package com.example.demo.Repository;

import com.example.demo.Entity.Details;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetailsRepository extends JpaRepository<Details, Integer> {
}
