package com.kartheek.ecommerce.features.address.controller;

import com.kartheek.ecommerce.features.address.model.AddressDTO;
import com.kartheek.ecommerce.features.address.service.AddressService;
import com.kartheek.ecommerce.util.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @PostMapping("/admin/address/add")
    public ResponseEntity<AddressDTO> addAddress(@RequestBody AddressDTO addressDTO){
        AddressDTO savedAddress = addressService.createAddress(addressDTO);
        return new ResponseEntity<>(savedAddress, HttpStatus.CREATED);
    }

    @GetMapping("/address/{userId}")
    public ResponseEntity<ApiResponse<List<AddressDTO>>> getProductsByCategory(@PathVariable Long userId) {
        List<AddressDTO> addresses = addressService.getAllAddressByUserId(userId);
        ApiResponse<List<AddressDTO>> response = new ApiResponse<>();
        response.setStatus(HttpStatus.OK.value());
        response.setSuccess(true);
        response.setMessage("Succeeded");
        response.setData(addresses);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
