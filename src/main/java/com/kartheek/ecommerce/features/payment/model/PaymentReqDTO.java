package com.kartheek.ecommerce.features.payment.model;

import com.kartheek.ecommerce.features.payment.PaymentStatus;

public class PaymentReqDTO {
    private String paymentStatus;

    private String paymentMethod;

    private Long userId;

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
