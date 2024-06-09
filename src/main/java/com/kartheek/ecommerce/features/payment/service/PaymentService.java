package com.kartheek.ecommerce.features.payment.service;


import com.kartheek.ecommerce.features.cart.model.CartDTO;
import com.kartheek.ecommerce.features.cart.model.request.AddToCartReqDTO;
import com.kartheek.ecommerce.features.payment.model.PaymentReqDTO;
import com.kartheek.ecommerce.features.payment.model.PaymentResDTO;

public interface PaymentService {
  PaymentResDTO processPayment(PaymentReqDTO paymentReqDTO);
}
