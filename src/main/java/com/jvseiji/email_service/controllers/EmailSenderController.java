package com.jvseiji.email_service.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jvseiji.email_service.core.EmailRequest;
import com.jvseiji.email_service.core.application.EmailSenderService;
import com.jvseiji.email_service.core.exceptions.EmailServiceException;

/*O controler serve para receber as requisições HTTP e disparará o email*/

@RestController
@RequestMapping("/api/email") //Qual endpoint será atendido?
public class EmailSenderController {
	
	private final EmailSenderService emailSenderService;
	
	@Autowired
	public EmailSenderController(EmailSenderService emailSenderService) {
		this.emailSenderService = emailSenderService; //Fará os disparos de emails
	}
	
	@PostMapping
	public ResponseEntity<String> sendEmail(@RequestBody EmailRequest request){
		try {
			this.emailSenderService.sendEmail(request.to(), request.subject(), request.body());
			return ResponseEntity.ok("email sent sucessfully!");
		}catch(EmailServiceException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error while sending email!");
		}
	}
	
}
