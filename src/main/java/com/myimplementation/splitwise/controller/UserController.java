package com.myimplementation.splitwise.controller;

import com.myimplementation.splitwise.dtos.RegisterUserRequestDTO;
import com.myimplementation.splitwise.dtos.RegisterUserResponseDTO;
import com.myimplementation.splitwise.dtos.Response;
import com.myimplementation.splitwise.exceptions.InvalidUserInputException;
import com.myimplementation.splitwise.models.User;
import com.myimplementation.splitwise.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    public RegisterUserResponseDTO registerUser(RegisterUserRequestDTO registerUserRequestDTO){
        RegisterUserResponseDTO registerUserResponseDTO=new RegisterUserResponseDTO();
        try{
            //input validations
            validateUserInput(registerUserRequestDTO.getUserName(),registerUserRequestDTO.getUserPassword(),registerUserRequestDTO.getPhone());

            //Passing to UserService
            User registeredUser = userService.register(registerUserRequestDTO.getUserName(), registerUserRequestDTO.getUserPassword(), registerUserRequestDTO.getPhone());

            registerUserResponseDTO.setUser(registeredUser);
            registerUserResponseDTO.setResponse(Response.getSuccessResponse());

        } catch (Exception e){
            Response response=Response.getFailureResponse(e.getMessage());
            registerUserResponseDTO.setResponse(response);
        }


        return registerUserResponseDTO;
    }

    public void validateUserInput(String userName,String userPassword,String phone) throws Exception{
        //input validations
        if(userName==null || userPassword==null || phone==null){
            throw new InvalidUserInputException("User or Password or Phone has no value and cannot be null.");
        }
        if(userPassword.length() <= 7){
            throw new InvalidUserInputException("Password must be atleast 7 characters. Current password length is " + userPassword.length());
            //Can add more validations on password like password should have numerics, symbols, UpperCase,etc
        }
    }
}
