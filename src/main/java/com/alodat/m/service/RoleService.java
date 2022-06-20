package com.alodat.m.service;

import com.alodat.m.model.Role;

public interface RoleService {
    Role findByName(String name);
}