package com.fabish.Ishimwe.service;

import com.fabish.Ishimwe.entity.Equipment;

import java.util.List;

public interface EquipmentService {
    List<Equipment> getAll();
    Equipment save(Equipment equipment);
    Equipment update(Long id, Equipment updated);
}
