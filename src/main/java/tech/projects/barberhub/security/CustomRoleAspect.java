package tech.projects.barberhub.security;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import tech.projects.barberhub.constants.users.UserConstants;
import tech.projects.barberhub.exceptions.security.RoleNotAllowedException;
import tech.projects.barberhub.constants.roles.RolesConstants;
import tech.projects.barberhub.security.annotations.HasAdminRole;

@Aspect
@Component
public class CustomRoleAspect {

    @Before("@annotation(hasAdminRole)")
    public void checkHasAdminRole(HasAdminRole hasAdminRole) {
        if (!hasRole(RolesConstants.ADMIN)) {
            throw new RoleNotAllowedException(UserConstants.ROLE_NOT_ALLOWED);
        }
    }

    private boolean hasRole(String role) {
        return SecurityContextHolder.getContext().getAuthentication().getAuthorities().stream()
                .anyMatch(authority -> authority.getAuthority().equals(role));
    }
}
