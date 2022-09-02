package de.neuefische.cgnjava222.basicregistrationpage.backend;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
public class AppUserService {

    private final Map<String, AppUser> appUsers = new HashMap<>(Map.of(
            "frank", new AppUser(
                    "frank",
                    "$2a$10$e.K27o4YsAM5ZWqj3PMPHeKY.Ho7NzR7pSMZPi.CY16k5ZT1.t7By" // = "frank123"
            )
    ));

    private final PasswordEncoder passwordEncoder;

    public AppUserService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public User loadUserByUsername(String username) {
        AppUser appUser = appUsers.get(username);
        return new User(appUser.username(), appUser.password(), Collections.emptyList());
    }

    public void register(NewUser newUser) {
        appUsers.put(newUser.username(), new AppUser(newUser.username(), passwordEncoder.encode(newUser.password())));
    }
}
