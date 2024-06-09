package com.kartheek.ecommerce.features.payment.controller;


import com.kartheek.ecommerce.admin.product.model.ProductDTO;
import com.kartheek.ecommerce.features.payment.model.PaymentReqDTO;
import com.kartheek.ecommerce.features.payment.model.PaymentResDTO;
import com.kartheek.ecommerce.features.payment.service.PaymentService;
import com.kartheek.ecommerce.util.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @PostMapping("/process")
    public ResponseEntity<ApiResponse<PaymentResDTO>> processPayment(@RequestBody PaymentReqDTO paymentReqDTO){
        PaymentResDTO savedPayment = paymentService.processPayment(paymentReqDTO);
        ApiResponse<PaymentResDTO> response = new ApiResponse<>();
        response.setStatus(HttpStatus.OK.value());
        response.setSuccess(true);
        response.setMessage("Succeeded");
        response.setData(savedPayment);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
