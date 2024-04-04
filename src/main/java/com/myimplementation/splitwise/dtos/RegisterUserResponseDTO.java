package com.myimplementation.splitwise.dtos;

import com.myimplementation.splitwise.models.User;
import lombok.Data;

@Data
public class RegisterUserResponseDTO {
    private User user;
    private Response response;
}
