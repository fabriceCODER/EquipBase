package com.fabish.Ishimwe.DTO;

import lombok.Data;

@Data
public class AuthRequest {
    private String email;
    private String password;
}