package com.fabish.Ishimwe.service;

import com.fabish.Ishimwe.entity.User;

public interface UserService {
    User findByEmail(String email);
    User save(User user);
}
