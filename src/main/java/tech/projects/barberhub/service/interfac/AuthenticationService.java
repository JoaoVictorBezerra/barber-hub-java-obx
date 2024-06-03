package tech.projects.barberhub.service.interfac;

import tech.projects.barberhub.dto.authentication.RequestLoginDTO;
import tech.projects.barberhub.dto.authentication.RequestRegisterDTO;
import tech.projects.barberhub.dto.authentication.ResponseLoginDTO;

public interface AuthenticationService {
    String register(RequestRegisterDTO registerUserDTO);
    ResponseLoginDTO login(RequestLoginDTO requestLoginDTO);
}
