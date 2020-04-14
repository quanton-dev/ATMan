package com.k0ft3.atman.model.processmodel;

import java.util.List;

import lombok.Data;

@Data
public class UserRole {
    private String role;
    private List<String> rolePermissions;
}