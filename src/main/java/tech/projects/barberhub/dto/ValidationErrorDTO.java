package tech.projects.barberhub.dto;

import java.time.Instant;
import java.util.List;

public record ValidationErrorDTO(
        List<String> errors,
        Instant timestamp
) {
}
