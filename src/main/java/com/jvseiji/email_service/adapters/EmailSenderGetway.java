package com.jvseiji.email_service.adapters;

/*A outra interface é muito semelhante (EmailSenderUserCase), mas poderia ser diferente, ela estabelece um contrato (Regra de Negócio). Foi uma coincidência*/



/*Para o meu EmailSenderService não depender diretamente do AWS, EmailGun e etc vamos criar uma interface, para não se ter essa dependência direta
 o mundo externo vai depender de uma interface e o meu serviço dependerá dela, ai sim quando eu for criar a classe do AWS, esta irá implementar essa interface.
 Tudo isso se chama interface adapter */


public interface EmailSenderGetway {
	void sendEmail(String to, String subject, String body);
}
