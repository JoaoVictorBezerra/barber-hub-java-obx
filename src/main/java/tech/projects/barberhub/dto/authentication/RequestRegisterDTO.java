package tech.projects.barberhub.dto.authentication;

public record RequestRegisterDTO(
        String name,
        String password,
        String email,
        String birthday
) {
}
