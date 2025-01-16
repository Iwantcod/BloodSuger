package com.example.demo.Repository;

import com.example.demo.Entity.History;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HistoryRepository extends JpaRepository<History, Integer> {
    public List<History> findAllByUserId(int userId);
    public boolean deleteAllByUserId(int userId);
}
