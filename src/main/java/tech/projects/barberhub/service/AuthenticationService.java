package tech.projects.barberhub.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import tech.projects.barberhub.constants.authentication.AuthenticationConstants;
import tech.projects.barberhub.dto.authentication.RequestLoginDTO;
import tech.projects.barberhub.dto.authentication.RequestRegisterDTO;
import tech.projects.barberhub.dto.authentication.ResponseLoginDTO;
import tech.projects.barberhub.exceptions.security.IncorrectPasswordOrEmailException;
import tech.projects.barberhub.mappers.user.UserMapper;
import tech.projects.barberhub.model.entity.user.User;
import tech.projects.barberhub.model.entity.user.UserRole;
import tech.projects.barberhub.security.TokenService;

@Service
public class AuthenticationService {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;

    UserMapper userMapper = new UserMapper();

    public AuthenticationService(UserService userService, PasswordEncoder passwordEncoder, TokenService tokenService) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
        this.tokenService = tokenService;
    }

    public String register(RequestRegisterDTO registerUserDTO) {
        User userEntity = userMapper.toEntity(registerUserDTO, passwordEncoder.encode(registerUserDTO.password()), UserRole.USER);
        userService.saveUser(userEntity);
        return userEntity.getId();
    }

    public ResponseLoginDTO login(RequestLoginDTO requestLoginDTO) {
        User userEntity = userService.getUserByEmail(requestLoginDTO.email());
        if(!passwordEncoder.matches(requestLoginDTO.password(), userEntity.getPassword())) {
            throw new IncorrectPasswordOrEmailException(AuthenticationConstants.WRONG_EMAIL_OR_PASSWORD);
        }
        String token = this.tokenService.generateToken(userEntity.getEmail(), userEntity.getRole().name());
        return new ResponseLoginDTO(userEntity.getName(), userEntity.getEmail(), token);
    }
}
