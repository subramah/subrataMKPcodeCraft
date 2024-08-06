package com.example.banking.dto;

public class ApiResponse {

	private final boolean statusCode;
    private final String message;

    public ApiResponse(String message, boolean statusCode) {
        super();
        this.statusCode = statusCode;
        this.message = message;
    }

    @Override
    public String toString() {
        return "ApiResponse: " + message + " - " +statusCode ;
    }

}
