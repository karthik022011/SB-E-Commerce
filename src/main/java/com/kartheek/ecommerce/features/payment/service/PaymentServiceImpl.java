package com.kartheek.ecommerce.features.payment.service;

import com.kartheek.ecommerce.features.payment.entity.Payment;
import com.kartheek.ecommerce.features.payment.model.PaymentReqDTO;
import com.kartheek.ecommerce.features.payment.model.PaymentResDTO;
import com.kartheek.ecommerce.features.payment.repository.PaymentRepository;
import com.kartheek.ecommerce.user.entity.RegisterUser;
import com.kartheek.ecommerce.user.repository.UserInfoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private UserInfoRepository userInfoRepository;

    @Override
    public PaymentResDTO processPayment(PaymentReqDTO paymentReqDTO) {
        Optional<RegisterUser> optionalUser = userInfoRepository.findById(paymentReqDTO.getUserId());
       // Payment payment = modelMapper.map(paymentReqDTO, Payment.class);
        Payment payment = new Payment();
        payment.setUser(optionalUser.get());
        payment.setPaymentStatus(paymentReqDTO.getPaymentStatus());
        payment.setPaymentMethod(paymentReqDTO.getPaymentMethod());
        Payment savedPayment = paymentRepository.save(payment);
        return modelMapper.map(savedPayment, PaymentResDTO.class);
    }
}
