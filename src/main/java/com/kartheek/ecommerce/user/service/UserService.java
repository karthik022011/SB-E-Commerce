package com.kartheek.ecommerce.user.service;



import com.kartheek.ecommerce.user.model.request.RegisterReqDTO;

import java.util.List;

public interface UserService {
    RegisterReqDTO createUser(RegisterReqDTO registerReqDTO);

    List<RegisterReqDTO> getAllUsers();

  //  UserResponse getAllUsers(Integer pageNumber, Integer pageSize, String sortBy, String sortOrder);


 //   UserDTO updateUser(Long userId, UserDTO userDTO);

 //   String deleteUser(Long userId);
}
