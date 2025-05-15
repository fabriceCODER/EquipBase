package com.fabish.Ishimwe.controller;

import com.fabish.Ishimwe.entity.Equipment;
import com.fabish.Ishimwe.repository.EquipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/equipment")
public class EquipmentController {
    @Autowired
    private EquipmentRepository repo;

    @GetMapping
    public List<Equipment> getAll() {
        return repo.findAll();
    }

    @PostMapping
    public Equipment addEquipment(@RequestBody Equipment equipment) {
        return repo.save(equipment);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateEquipment(@PathVariable Long id, @RequestBody Equipment newData) {
        return repo.findById(id)
                .map(eq -> {
                    eq.setName(newData.getName());
                    eq.setQuantity(newData.getQuantity());
                    eq.setType(newData.getType());
                    eq.setLocation(newData.getLocation());
                    eq.setStatus(newData.getStatus());
                    return ResponseEntity.ok(repo.save(eq));
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
