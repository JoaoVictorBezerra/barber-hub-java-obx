package tech.projects.barberhub.dto.authentication;

public record ResponseLoginDTO(
        String name,
        String email,
        String token
) {
}
