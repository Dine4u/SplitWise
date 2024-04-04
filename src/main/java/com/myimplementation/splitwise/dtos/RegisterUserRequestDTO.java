package com.myimplementation.splitwise.dtos;


import lombok.Data;

@Data
public class RegisterUserRequestDTO {

    private String userName;
    private String userPassword;
    private String phone;
}
