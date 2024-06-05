package tech.projects.barberhub.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.projects.barberhub.constants.api.Routes;
import tech.projects.barberhub.dto.DefaultResponseDTO;
import tech.projects.barberhub.dto.communication.email.RequestEmailSendDTO;
import tech.projects.barberhub.service.interfac.EmailService;

import java.time.Instant;

@RestController
@RequestMapping(Routes.SENDMAIL)
public class EmailController {
    final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping
    public ResponseEntity<DefaultResponseDTO> sendEmail(@RequestBody RequestEmailSendDTO body) {
        emailService.sendEmail(body);
        return ResponseEntity.ok(new DefaultResponseDTO("Email successfully sent!", Instant.now()));
    }
}
