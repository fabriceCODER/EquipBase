package com.fabish.Ishimwe.controller;

import com.fabish.Ishimwe.entity.AllocationLog;
import com.fabish.Ishimwe.repository.AllocationLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/logs")
public class AllocationLogController {
    @Autowired
    private AllocationLogRepository repo;

    @GetMapping
    public List<AllocationLog> getAllLogs() {
        return repo.findAll();
    }
}

