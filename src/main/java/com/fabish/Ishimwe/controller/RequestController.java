package com.fabish.Ishimwe.controller;

import com.fabish.Ishimwe.entity.Equipment;
import com.fabish.Ishimwe.entity.Request;
import com.fabish.Ishimwe.entity.User;
import com.fabish.Ishimwe.repository.EquipmentRepository;
import com.fabish.Ishimwe.repository.RequestRepository;
import com.fabish.Ishimwe.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/requests")
public class RequestController {
    @Autowired
    private RequestRepository repo;
    @Autowired private UserRepository userRepo;
    @Autowired private EquipmentRepository equipmentRepo;

    @PostMapping
    public ResponseEntity<?> createRequest(@RequestBody Map<String, Object> data) {
        Long userId = Long.parseLong(data.get("userId").toString());
        Long equipmentId = Long.parseLong(data.get("equipmentId").toString());
        String purpose = data.get("purpose").toString();

        Optional<User> user = userRepo.findById(userId);
        Optional<Equipment> equipment = equipmentRepo.findById(equipmentId);

        if (user.isEmpty() || equipment.isEmpty()) {
            return ResponseEntity.badRequest().body("Invalid user or equipment");
        }

        Request request = new Request();
        request.setUser(user.get());
        request.setEquipment(equipment.get());
        request.setPurpose(purpose);
        request.setStatus("pending");

        return ResponseEntity.ok(repo.save(request));
    }

    @PutMapping("/{id}/approve")
    public ResponseEntity<?> approveRequest(@PathVariable Long id) {
        return repo.findById(id).map(r -> {
            r.setStatus("approved");
            return ResponseEntity.ok(repo.save(r));
        }).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}/reject")
    public ResponseEntity<?> rejectRequest(@PathVariable Long id) {
        return repo.findById(id).map(r -> {
            r.setStatus("rejected");
            return ResponseEntity.ok(repo.save(r));
        }).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<Request> getAll() {
        return repo.findAll();
    }
}
