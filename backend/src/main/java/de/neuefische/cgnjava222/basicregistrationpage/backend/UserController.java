package de.neuefische.cgnjava222.basicregistrationpage.backend;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final AppUserService appUserService;

    public UserController(AppUserService appUserService) {
        this.appUserService = appUserService;
    }

    @GetMapping("login")
    public void login() {
        System.out.println("Logged in");
    }

    @GetMapping("me")
    public String me() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }

    @GetMapping("logout")
    public void logout(HttpSession session) {
        session.invalidate();
        System.out.println("Logged out");
    }

    @PostMapping
    public void register(@RequestBody NewUser newUser) {
        appUserService.register(newUser);
        System.out.println("Registered");
    }
}
