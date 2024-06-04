package com.kartheek.ecommerce.user.controller;


import com.kartheek.ecommerce.user.model.request.RegisterReqDTO;
import com.kartheek.ecommerce.user.service.UserService;
import com.kartheek.ecommerce.util.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/admin/users")
    public ResponseEntity<ApiResponse<List<RegisterReqDTO>>> getAllUsers(){
        List<RegisterReqDTO> users = userService.getAllUsers();
        ApiResponse<List<RegisterReqDTO>> response = new ApiResponse<>();
        response.setStatus(HttpStatus.OK.value());
        response.setSuccess(true);
        response.setMessage("Succeeded");
        response.setData(users);
        return ResponseEntity.status(HttpStatus.OK).body(response);

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
