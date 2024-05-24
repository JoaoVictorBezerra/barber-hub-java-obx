package tech.projects.barberhub.dto.barbershop;

import jakarta.validation.constraints.NotBlank;
import tech.projects.barberhub.constants.validations.ValidationsConstants;

public record AddServiceOnBarbershopDTO(
        @NotBlank(message = ValidationsConstants.ID_BLANK) String serviceId
) {
}
