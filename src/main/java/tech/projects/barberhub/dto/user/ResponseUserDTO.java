package tech.projects.barberhub.dto.user;

public record ResponseUserDTO(
    String id,
    String name,
    String email,
    String createdAt,
    String updatedAt
) {
}
