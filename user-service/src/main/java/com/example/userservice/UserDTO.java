package com.example.userservice;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {

    private Long individualNumber;
    private String firstName;
    private String lastName;
    private String phoneNumber;

    public UserDTO(Long individualNumber, String firstName, String lastName, String phoneNumber) {
        this.individualNumber = individualNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }
}
