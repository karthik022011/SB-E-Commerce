package com.kartheek.ecommerce.features.cart.repository;


import com.kartheek.ecommerce.features.address.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Address, Long> {

}
