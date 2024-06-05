package tech.projects.barberhub.dto.communication.email;

public record RequestEmailSendDTO(
        String email,
        String description
) {
}
