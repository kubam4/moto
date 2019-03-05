package com.machi.service;

import com.machi.model.Role;
import com.machi.model.User;
import com.machi.repository.RoleRepository;
import com.machi.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    private final PasswordEncoder passwordEncoder;

    private final PasswordValidator passwordValidator;

    public UserServiceImpl(final UserRepository userRepository, final RoleRepository roleRepository, final PasswordEncoder passwordEncoder, final PasswordValidator passwordValidator) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.passwordValidator = passwordValidator;
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public void saveUser(User user) {
//        passwordValidator.validate(user.getPassword(), user.getPassword());

        Role userRole = roleRepository.findByName("ADMIN");
        user.setUserRoles(Collections.singleton(userRole));

        userRepository.save(user);
    }

    @Override
    public User findById(final long userId) {
        return userRepository.getOne(userId);
    }
}
