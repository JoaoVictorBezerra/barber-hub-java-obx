package tech.projects.barberhub.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.projects.barberhub.constants.api.Routes;
import tech.projects.barberhub.dto.authentication.RequestLoginDTO;
import tech.projects.barberhub.dto.authentication.RequestRegisterDTO;
import tech.projects.barberhub.dto.authentication.ResponseLoginDTO;
import tech.projects.barberhub.service.interfac.AuthenticationService;

import java.net.URI;

@RestController
@RequestMapping(Routes.AUTHENTICATION)
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }
    @PostMapping
    public ResponseEntity<ResponseLoginDTO> login(@RequestBody RequestLoginDTO body) {
        ResponseLoginDTO response = authenticationService.login(body);
        return ResponseEntity.ok(response);
    }
    @PostMapping("/register")
    public ResponseEntity<ResponseLoginDTO> register(@Valid @RequestBody RequestRegisterDTO body) {
        String userId = authenticationService.register(body);
        return ResponseEntity.created(URI.create("/api/users/" + userId)).build();
    }
}
