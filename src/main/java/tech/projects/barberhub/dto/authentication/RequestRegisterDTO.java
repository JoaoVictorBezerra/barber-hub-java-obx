package tech.projects.barberhub.dto.authentication;

import jakarta.validation.constraints.NotBlank;
import tech.projects.barberhub.constants.validations.ValidationsConstants;
import tech.projects.barberhub.validation.annotations.ValidDate;

public record RequestRegisterDTO(
        @NotBlank(message = ValidationsConstants.NAME_BLANK) String name,
        @NotBlank(message = ValidationsConstants.EMAIL_BLANK) String email,
        @NotBlank(message = ValidationsConstants.BIRTHDAY_BLANK)
        @ValidDate(message = ValidationsConstants.BIRTHDAY_INVALID)
        String birthday,
        @NotBlank(message = ValidationsConstants.PASSWORD_BLANK)
        String password
) {
}
