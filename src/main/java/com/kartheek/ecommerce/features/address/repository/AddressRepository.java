package com.kartheek.ecommerce.features.address.repository;


import com.kartheek.ecommerce.features.address.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
