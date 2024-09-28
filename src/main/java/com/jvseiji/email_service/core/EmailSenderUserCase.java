package com.jvseiji.email_service.core;

//Caso de Uso, o que a minha aplicação irá fazer = funcionalidade; Sem entrar em detalhes de aplicação/ Contrato == + alto nível;
public interface EmailSenderUserCase {
	
	void sendEmail(String to, String subject, String body);

}
