package com.example.BmsMarch24.dtos;

import com.example.BmsMarch24.enums.ResponseStatus;
import lombok.Data;

@Data
public class Response {
    private ResponseStatus responseStatus;
    private String error;

    public Response(ResponseStatus responseStatus, String error) {
        this.responseStatus = responseStatus;
        this.error = error;
    }

    public static Response getfailureResponse(String error){
        return new Response(ResponseStatus.FAILURE, error);
    }

    public static Response getSuccessResponse(){
        return new Response(ResponseStatus.SUCCESS, null);
    }
}
