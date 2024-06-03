package tech.projects.barberhub.mappers.user;

import tech.projects.barberhub.dto.authentication.RequestRegisterDTO;
import tech.projects.barberhub.model.user.User;
import tech.projects.barberhub.model.user.UserRole;

import java.time.Instant;
import java.util.UUID;

public final class UserMapper {
    public User toEntity(RequestRegisterDTO dto, String encodedPassword, UserRole role) {
        return new User(
                UUID.randomUUID().toString(),
                dto.name(),
                dto.email(),
                encodedPassword,
                dto.birthday(),
                Instant.now(),
                null,
                role
        );
    }
}
