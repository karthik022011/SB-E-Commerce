package com.kartheek.ecommerce.user.controller;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {

    @PostMapping("/admin/users")
    public void getAllUsers(){

    }

    //Can access both admin and user
    @PostMapping("/user/update")
    public void updateUser(){

    }

    //Can access both admin and user
    @PostMapping("/user/delete")
    public void  deleteUser(){

    }

}
