package com.fabish.Ishimwe.service;

import com.fabish.Ishimwe.config.ResourceNotFoundException;
import com.fabish.Ishimwe.entity.Equipment;
import com.fabish.Ishimwe.repository.EquipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipmentServiceImpl implements EquipmentService {
    @Autowired
    private EquipmentRepository repo;

    @Override
    public List<Equipment> getAll() {
        return repo.findAll();
    }

    @Override
    public Equipment save(Equipment equipment) {
        return repo.save(equipment);
    }

    @Override
    public Equipment update(Long id, Equipment updated) {
        Equipment e = repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Equipment not found"));
        e.setName(updated.getName());
        e.setLocation(updated.getLocation());
        e.setQuantity(updated.getQuantity());
        e.setStatus(updated.getStatus());
        e.setType(updated.getType());
        return repo.save(e);
    }
}
