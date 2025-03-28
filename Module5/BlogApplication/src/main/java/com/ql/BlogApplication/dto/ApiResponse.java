package com.ql.BlogApplication.dto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiResponse<T> {
    private int status;
    private String message;
    T data;

    ApiResponse(int status,String message,T data){
            this.status=status;
            this.message=message;
            this.data=data;
    }
}
