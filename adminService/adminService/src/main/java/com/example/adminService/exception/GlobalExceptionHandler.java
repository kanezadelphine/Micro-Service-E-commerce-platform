package com.example.adminService.exception;



import com.example.adminService.dto.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiResponse<String> handleException(Exception ex) {

        return new ApiResponse<>(
                false,
                ex.getMessage(),
                null
        );
    }

}