package org.generation.muebleria.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/api/auth")
@AllArgsConstructor
public class AuthContoller {
//    //inyectar el servicio
//    private final UsersServiceImpl usersService;
//
//    @PostMapping(path = "/register")
//    public Users registerUser(@RequestBody Users user){
//        return usersService.addUser(user);
//    }
//
//    @PostMapping(path = "/login")
//    public boolean loginUser(@RequestBody Users user){
//        return usersService.validateUser(user);
//    }
}
