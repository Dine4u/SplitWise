package com.myimplementation.splitwise.dtos;

import lombok.Data;

@Data
public class Response {
    private ResponseType responseType;
    private String message;

    public static Response getFailureResponse(String message){
        Response response=new Response();
        response.setResponseType(ResponseType.FAILURE);
        response.setMessage(message);
        return response;
    }
    public static Response getSuccessResponse(){
        Response response=new Response();
        response.setResponseType(ResponseType.SUCCESS);
        return response;
    }
}
