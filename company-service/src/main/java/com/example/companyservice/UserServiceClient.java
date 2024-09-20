package com.example.companyservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "user-service", url = "${user.service.url}")
public interface UserServiceClient {

    @GetMapping("/users/lastname/{lastName}")
    List<UserDTO> getUsersByLastName(@PathVariable("lastName") String lastName);

    @GetMapping("/users/{id}")
    UserDTO getUserById(@PathVariable("id") Long id);
}
