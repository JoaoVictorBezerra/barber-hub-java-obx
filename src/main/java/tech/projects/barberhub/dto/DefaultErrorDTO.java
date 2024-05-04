package tech.projects.barberhub.dto;

import java.time.Instant;

public record DefaultErrorDTO(
        String message,
        Instant timestamp
) {
}
