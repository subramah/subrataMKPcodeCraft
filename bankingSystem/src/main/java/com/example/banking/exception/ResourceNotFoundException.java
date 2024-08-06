package com.example.banking.exception;

public class ResourceNotFoundException extends RuntimeException {
		 
		public ResourceNotFoundException()
		{
			super("Account with the given Id not on the server...pl enter an existing id");
		}
		public ResourceNotFoundException(String message)
		{
			super(message);
		}

}
