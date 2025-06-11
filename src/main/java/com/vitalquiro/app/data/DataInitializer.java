package com.vitalquiro.app.data;

import com.vitalquiro.app.data.Role;
import com.vitalquiro.app.data.User;
import com.vitalquiro.app.services.UserService;
import jakarta.annotation.PostConstruct;
import java.util.Set;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@SuppressWarnings("unused")
@Component
public class DataInitializer {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public DataInitializer(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostConstruct
    public void init() {
        if (userService.count() == 0) {
            User admin = new User();
            admin.setUsername("adminmaster@vitalquiro.com");
            admin.setName("Admin Master");
            admin.setHashedPassword(passwordEncoder.encode("vitalquiroadmin"));
            admin.setRoles(Set.of(Role.ADMIN));
            userService.save(admin);
        }
    }
}