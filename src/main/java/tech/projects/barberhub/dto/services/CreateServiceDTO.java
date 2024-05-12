package tech.projects.barberhub.dto.services;

public record CreateServiceDTO(
        String name,
        String description,
        double price
) {
}
