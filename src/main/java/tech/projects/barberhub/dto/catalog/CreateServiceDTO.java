package tech.projects.barberhub.dto.catalog;

import jakarta.validation.constraints.*;
import tech.projects.barberhub.constants.validations.ValidationsConstants;

public record CreateServiceDTO(
        @NotBlank(message = ValidationsConstants.NAME_BLANK) String name,
        @NotBlank(message = ValidationsConstants.DESCRIPTION_BLANK) String description,
        @NotBlank(message = ValidationsConstants.IMAGE_BLANK) String imageUrl,
        @NotNull(message = ValidationsConstants.PRICE_NULL) Double price
) {
}
