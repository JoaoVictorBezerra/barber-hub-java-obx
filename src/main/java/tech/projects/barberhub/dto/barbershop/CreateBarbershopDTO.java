package tech.projects.barberhub.dto.barbershop;

import jakarta.validation.constraints.*;
import tech.projects.barberhub.constants.validations.ValidationsConstants;

public record CreateBarbershopDTO(
        @NotBlank(message = ValidationsConstants.NAME_BLANK) String name,
        @NotBlank(message = ValidationsConstants.DESCRIPTION_BLANK) String description,
        @NotBlank(message = ValidationsConstants.ADDRESS_BLANK) String address,
        @NotBlank(message = ValidationsConstants.IMAGE_BLANK) String imageUrl,
        @NotBlank(message = ValidationsConstants.CONTACT_BLANK) String contact
) {
}
