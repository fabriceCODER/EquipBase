package com.fabish.Ishimwe.controller;

import com.fabish.Ishimwe.entity.Request;
import com.fabish.Ishimwe.entity.Return;
import com.fabish.Ishimwe.repository.RequestRepository;
import com.fabish.Ishimwe.repository.ReturnRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/returns")
public class ReturnController {
    @Autowired
    private ReturnRepository returnRepo;
    @Autowired private RequestRepository requestRepo;

    @PostMapping
    public ResponseEntity<?> returnEquipment(@RequestBody Map<String, Object> data) {
        Long requestId = Long.parseLong(data.get("requestId").toString());
        String condition = data.get("condition").toString();

        Optional<Request> req = requestRepo.findById(requestId);
        if (req.isEmpty()) return ResponseEntity.badRequest().body("Invalid request");

        Return ret = new Return();
        ret.setRequest(req.get());
        ret.setCondition(condition);

        return ResponseEntity.ok(returnRepo.save(ret));
    }
}

