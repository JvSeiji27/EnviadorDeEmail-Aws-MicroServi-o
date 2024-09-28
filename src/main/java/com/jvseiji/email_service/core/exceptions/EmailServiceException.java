package com.jvseiji.email_service.core.exceptions;

public class EmailServiceException extends RuntimeException{
	
	//Super está chamando o construtor da classe Base, que é o Runtime, atribuindo certos valores
	
	public EmailServiceException(String msg) {
		super(msg);
	}
	
	public EmailServiceException(String msg, Throwable cause) {
		super(msg, cause);
	}

}
