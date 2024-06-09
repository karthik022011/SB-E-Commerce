package com.kartheek.ecommerce.features.payment.repository;


import com.kartheek.ecommerce.features.payment.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {

}
