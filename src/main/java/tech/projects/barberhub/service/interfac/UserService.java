package tech.projects.barberhub.service.interfac;

import tech.projects.barberhub.dto.user.ResponseUserDTO;
import tech.projects.barberhub.model.user.User;

public interface UserService {
    ResponseUserDTO getUserById(String id);
    User getUserByEmail(String email);
    void saveUser(User userEntity);
    void deleteUser(String id);
}
