package tech.projects.barberhub.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.projects.barberhub.dto.user.ResponseUserDTO;
import tech.projects.barberhub.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<ResponseUserDTO> getUserById(@PathVariable("userId") String id) {
        ResponseUserDTO response = userService.getUserById(id);
        return ResponseEntity.ok(response);
    }
}
