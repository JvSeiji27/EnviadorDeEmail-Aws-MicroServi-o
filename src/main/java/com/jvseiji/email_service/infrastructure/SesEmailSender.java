package com.jvseiji.email_service.infrastructure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.model.Body;
import com.amazonaws.services.simpleemail.model.Content;
import com.amazonaws.services.simpleemail.model.Destination;
import com.amazonaws.services.simpleemail.model.Message;
import com.amazonaws.services.simpleemail.model.SendEmailRequest;
import com.jvseiji.email_service.adapters.EmailSenderGetway;
import com.jvseiji.email_service.core.exceptions.EmailServiceException;


@Service
public class SesEmailSender implements EmailSenderGetway{

	
	private final AmazonSimpleEmailService amazonSimpleEmailService;
	
	@Autowired //Quer dizer que isto será injetado diretamente pelo Spring/ Não teremos aquela instanciação padrão e injeção nas classes
	public SesEmailSender(AmazonSimpleEmailService amazonSimpleEmailService) {
		this.amazonSimpleEmailService = amazonSimpleEmailService;
	}
	
	@Override
	public void sendEmail(String to, String subject, String body) {
		SendEmailRequest request = new SendEmailRequest()
				.withSource("joaovssc@gmail.com")
				.withDestination(new Destination().withToAddresses(to))
				.withMessage(new Message().withSubject(new Content(subject)).withBody(new Body().withText(new Content(body)))
						);
		try{
			this.amazonSimpleEmailService.sendEmail(request);
		}catch(AmazonServiceException e) {
			throw new EmailServiceException("Failure while sending email!");
		}
				
	}

}
