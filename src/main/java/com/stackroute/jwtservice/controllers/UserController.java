package com.stackroute.jwtservice.controllers;

import com.stackroute.jwtservice.models.ApplicationUser;
import com.stackroute.jwtservice.repositories.ApplicationUserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private ApplicationUserRepository applicationUserRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserController(ApplicationUserRepository applicationUserRepository) {
        this.applicationUserRepository = applicationUserRepository;
        this.bCryptPasswordEncoder = new BCryptPasswordEncoder();
    }

    @PostMapping("/record")
    public void signUp(@RequestBody ApplicationUser user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        applicationUserRepository.save(user);
    }
    @GetMapping("/one")
    public void getOne(){
        applicationUserRepository.getOne((long)1);
    }
}