package tech.projects.barberhub.dto;

import java.time.Instant;

public record DefaultResponseDTO(
        String message,
        Instant timestamp
) {
}
