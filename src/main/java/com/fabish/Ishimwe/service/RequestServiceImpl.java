package com.fabish.Ishimwe.service;

import com.fabish.Ishimwe.config.ResourceNotFoundException;
import com.fabish.Ishimwe.entity.Equipment;
import com.fabish.Ishimwe.entity.Request;
import com.fabish.Ishimwe.entity.User;
import com.fabish.Ishimwe.repository.EquipmentRepository;
import com.fabish.Ishimwe.repository.RequestRepository;
import com.fabish.Ishimwe.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestServiceImpl implements RequestService {
    @Autowired
    private RequestRepository repo;
    @Autowired private UserRepository userRepo;
    @Autowired private EquipmentRepository equipmentRepo;

    @Override
    public Request createRequest(Long userId, Long equipmentId, String purpose) {
        User user = userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found"));
        Equipment equipment = equipmentRepo.findById(equipmentId).orElseThrow(() -> new ResourceNotFoundException("Equipment not found"));

        Request request = new Request();
        request.setUser(user);
        request.setEquipment(equipment);
        request.setPurpose(purpose);
        request.setStatus("pending");
        return repo.save(request);
    }

    @Override
    public Request approveRequest(Long id) {
        Request req = repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Request not found"));
        req.setStatus("approved");
        return repo.save(req);
    }

    @Override
    public Request rejectRequest(Long id) {
        Request req = repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Request not found"));
        req.setStatus("rejected");
        return repo.save(req);
    }

    @Override
    public List<Request> getAll() {
        return repo.findAll();
    }
}
