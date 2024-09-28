package com.jvseiji.email_service.core.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jvseiji.email_service.adapters.EmailSenderGetway;
import com.jvseiji.email_service.core.EmailSenderUserCase;
//Ainda não é nessa camada que iremos implementar o Amazon SES

@Service
public class EmailSenderService implements EmailSenderUserCase{

	private final EmailSenderGetway emailSenderGetway;
	
	@Autowired
	public EmailSenderService(EmailSenderGetway emailSenderGetway){
		this.emailSenderGetway = emailSenderGetway;
	}
	
	
	@Override
	public void sendEmail(String to, String subject, String body) {
		this.emailSenderGetway.sendEmail(to, subject, body);
	}

}
