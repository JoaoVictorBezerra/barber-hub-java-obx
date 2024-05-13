package tech.projects.barberhub.dto.authentication;

public record RequestLoginDTO(
        String email,
        String password
) {
}
