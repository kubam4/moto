package com.machi.service;

import com.machi.model.User;

public interface UserService {

    User findUserByEmail(String email);

    void saveUser(User user);

    User findById(long userId);
}
