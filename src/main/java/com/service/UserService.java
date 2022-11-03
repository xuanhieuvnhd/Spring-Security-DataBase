package com.service;

import com.model.User;

public interface UserService {
    User getUserByUsername(String username);
}
