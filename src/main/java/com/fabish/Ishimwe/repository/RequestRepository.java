package com.fabish.Ishimwe.repository;

import com.fabish.Ishimwe.entity.Request;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RequestRepository extends JpaRepository<Request, Long> {
    List<Request> findByUserId(Long userId);
}
