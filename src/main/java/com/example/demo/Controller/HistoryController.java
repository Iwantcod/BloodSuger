package com.example.demo.Controller;

import com.example.demo.DTO.HistoryDTO;
import com.example.demo.Service.HistoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/history")
public class HistoryController {

    private final HistoryService historyService;

    public HistoryController(HistoryService historyService) {
        this.historyService = historyService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addHistory(@RequestBody HistoryDTO historyDTO) {
        if(historyService.addHistory(historyDTO) == null) {
            return ResponseEntity.status(400).body("History Not Add");
        } else {
            return ResponseEntity.ok(historyService.addHistory(historyDTO));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getHistoryById(@PathVariable int id) {
        if(historyService.getHistoryById(id) == null) {
            return ResponseEntity.status(400).body("History Not Found");
        } else {
            return ResponseEntity.ok(historyService.getHistoryById(id));
        }
    }

    @GetMapping("/{userId}/owned")
    public ResponseEntity<?> getAllHistoryByUserId(@PathVariable int userId) {
        if(historyService.getAllHistoryByUserId(userId) == null) {
            return ResponseEntity.status(400).body("History Not Found");
        } else {
            return ResponseEntity.ok(historyService.getAllHistoryByUserId(userId));
        }
    }

    @PatchMapping("/")
    public ResponseEntity<?> updateHistory(@RequestBody HistoryDTO historyDTO) {
        if(historyService.updateHistory(historyDTO)) {
            return ResponseEntity.ok("History Updated");
        } else {
            return ResponseEntity.status(400).body("History Not Updated");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteHistoryById(@PathVariable int id) {
        if(historyService.deleteHistoryById(id)) {
            return ResponseEntity.ok("History Deleted");
        } else {
            return ResponseEntity.status(400).body("History Not Deleted");
        }
    }

    @DeleteMapping("/{userId}/owned")
    public ResponseEntity<?> deleteHistoryByUserId(@PathVariable int userId) {
        if(historyService.deleteHistoryByUserId(userId)) {
            return ResponseEntity.ok("Target User's History Deleted");
        } else {
            return ResponseEntity.status(400).body("Target User's History Not Deleted");
        }
    }
}
