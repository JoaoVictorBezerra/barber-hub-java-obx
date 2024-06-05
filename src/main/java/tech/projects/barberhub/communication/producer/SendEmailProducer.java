package tech.projects.barberhub.communication.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;
import tech.projects.barberhub.dto.communication.email.RequestEmailSendDTO;

@Component
public class SendEmailProducer {
    private AmqpTemplate amqpTemplate;

    public SendEmailProducer(AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }

    private final ObjectMapper objectMapper = new ObjectMapper();

    public void sendEmail(RequestEmailSendDTO requestEmailSendDTO) throws JsonProcessingException {
        amqpTemplate.convertAndSend(
                "email-request-exchange",
                "email-request-routing-key",
                objectMapper.writeValueAsString(requestEmailSendDTO)
        );

    }
}
