package tech.projects.barberhub.service.interfac;

import tech.projects.barberhub.dto.communication.email.RequestEmailSendDTO;

public interface EmailService {
    void sendEmail(RequestEmailSendDTO requestEmailSendDTO);
}
