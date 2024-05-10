package com.example.springpractice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data@AllArgsConstructor
@NoArgsConstructor
public class UserModel {
    private String username;
    private String password;
    private String roles;
    private boolean active;
}
