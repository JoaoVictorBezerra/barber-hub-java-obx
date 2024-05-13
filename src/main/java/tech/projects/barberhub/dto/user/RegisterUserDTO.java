package tech.projects.barberhub.dto.user;

public record RegisterUserDTO(
        String name,
        String email,
        String password
) {
}
