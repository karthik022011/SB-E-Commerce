package com.kartheek.ecommerce.user.controller;


import com.kartheek.ecommerce.user.model.request.RegisterReqDTO;
import com.kartheek.ecommerce.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @PostMapping("/signup")
    public ResponseEntity<RegisterReqDTO> createUser(@RequestBody RegisterReqDTO registerReqDTO){
        RegisterReqDTO savedUser = userService.createUser(registerReqDTO);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

}
