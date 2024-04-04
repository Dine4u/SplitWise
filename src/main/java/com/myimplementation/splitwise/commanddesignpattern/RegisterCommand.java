package com.myimplementation.splitwise.commanddesignpattern;

import com.myimplementation.splitwise.controller.UserController;
import com.myimplementation.splitwise.dtos.RegisterUserRequestDTO;
import com.myimplementation.splitwise.dtos.RegisterUserResponseDTO;
import com.myimplementation.splitwise.dtos.ResponseType;
import com.myimplementation.splitwise.exceptions.InvalidCommandException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RegisterCommand implements Command{

    private UserController userController;

    @Autowired
    public RegisterCommand(UserController userController){
        this.userController=userController;
        CommandRegistry.getInstance().addCommand(CommandTypes.REGISTER,this);
    }
    @Override
    public void execute(String input) throws InvalidCommandException {
        String[] s=input.split(" ");
        if(s.length!=4){
            throw new InvalidCommandException("Please check input command syntax");
        }

        RegisterUserRequestDTO registerUserRequestDTO=new RegisterUserRequestDTO();
//        System.out.println(s[1]);//debugging statements
//        System.out.println(s[2]);
//        System.out.println(s[3]);
        registerUserRequestDTO.setUserName(s[1]);
        registerUserRequestDTO.setUserPassword(s[2]);
        registerUserRequestDTO.setPhone(s[3]);

        RegisterUserResponseDTO registerUserResponseDTO = userController.registerUser(registerUserRequestDTO);

        if(registerUserResponseDTO.getResponse().getResponseType()== ResponseType.FAILURE){
            System.out.println("User cannot be registered due to following Error" );
            System.out.println("Error:");
            System.out.println(registerUserResponseDTO.getResponse().getMessage());
        } else {
            System.out.println("User registered");
            System.out.println(registerUserResponseDTO.getUser());
        }
    }
}
