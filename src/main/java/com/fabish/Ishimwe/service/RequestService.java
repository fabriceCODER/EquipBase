package com.fabish.Ishimwe.service;

import com.fabish.Ishimwe.entity.Request;

import java.util.List;

public interface RequestService {
    Request createRequest(Long userId, Long equipmentId, String purpose);
    Request approveRequest(Long id);
    Request rejectRequest(Long id);
    List<Request> getAll();
}

