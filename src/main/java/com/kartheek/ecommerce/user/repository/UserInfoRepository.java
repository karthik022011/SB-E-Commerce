package com.kartheek.ecommerce.user.repository;


import com.kartheek.ecommerce.user.entity.RegisterUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInfoRepository extends JpaRepository<RegisterUser, Long> {

}
