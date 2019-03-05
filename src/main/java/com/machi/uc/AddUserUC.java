package com.machi.uc;

import com.machi.model.User;
import com.machi.service.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

@Component
public class AddUserUC {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public AddUserUC(final UserService userService, final PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional(rollbackFor = Exception.class)
    public void addUser(UserDto userDto) throws Exception {
        final String password = userDto.getPassword();
        final String password2 = userDto.getPasswordTwo();
        if (StringUtils.isEmpty(password)) {
            throw new Exception("Hasło nie może być puste.");
        }
        if (!password.equals(password2)) {
            throw new Exception("Podane hasła są nieprawidłowe.");
        }
        final String encodedPassword = passwordEncoder.encode(password);
        final User user = new User(userDto, encodedPassword);
        userService.saveUser(user);
    }

}
