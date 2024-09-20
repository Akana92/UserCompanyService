package com.example.userservice;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "users")
public class User {

    @Id
    private Long individualNumber;
    private String firstName;
    private String lastName;
    private String phoneNumber;

    public User() {}

    public User(Long individualNumber, String firstName, String lastName, String phoneNumber) {
        this.individualNumber = individualNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }
}
