package tech.projects.barberhub.dto.catalog;

import jakarta.validation.constraints.*;
import tech.projects.barberhub.constants.catalog.CatalogConstants;

public record CreateServiceDTO(
        @NotBlank(message = CatalogConstants.NAME_BLANK) String name,
        @NotBlank(message = CatalogConstants.DESCRIPTION_BLANK) String description,
        @NotBlank(message = CatalogConstants.IMAGE_BLANK) String imageUrl,
        @NotNull(message = CatalogConstants.PRICE_NULL) Double price
) {
}
