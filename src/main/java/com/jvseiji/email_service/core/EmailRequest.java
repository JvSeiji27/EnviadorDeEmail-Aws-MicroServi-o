package com.jvseiji.email_service.core;

//Uma ferramenta chamada de DTO capaz de transferir apenas dados necessários, filtramos para quem, assunto e o quê.

public record EmailRequest(String to, String subject, String body) {

}
