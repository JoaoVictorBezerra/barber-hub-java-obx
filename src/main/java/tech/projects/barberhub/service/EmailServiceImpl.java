package tech.projects.barberhub.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Service;
import tech.projects.barberhub.communication.producer.SendEmailProducer;
import tech.projects.barberhub.dto.communication.email.RequestEmailSendDTO;
import tech.projects.barberhub.service.interfac.EmailService;

@Service
public class EmailServiceImpl implements EmailService {

    final SendEmailProducer emailProducer;

    public EmailServiceImpl(SendEmailProducer emailProducer) {
        this.emailProducer = emailProducer;
    }

    @Override
    public void sendEmail(RequestEmailSendDTO requestEmailSendDTO) {
        try {
            emailProducer.sendEmail(requestEmailSendDTO);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
