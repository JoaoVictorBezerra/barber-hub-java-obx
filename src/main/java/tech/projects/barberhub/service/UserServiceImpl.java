package tech.projects.barberhub.service;

import org.springframework.stereotype.Service;
import tech.projects.barberhub.dto.user.ResponseUserDTO;
import tech.projects.barberhub.exceptions.users.UserAlreadyRegisteredException;
import tech.projects.barberhub.exceptions.users.UserNotFoundException;
import tech.projects.barberhub.constants.users.UserConstants;
import tech.projects.barberhub.model.user.User;
import tech.projects.barberhub.repository.UserRepository;
import tech.projects.barberhub.service.interfac.UserService;

@Service
public class UserServiceImpl implements UserService  {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ResponseUserDTO getUserById(String id) {
        User userEntity = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(UserConstants.NOT_FOUND));
        return new ResponseUserDTO(userEntity.getId(), userEntity.getName(), userEntity.getEmail(), userEntity.getCreatedAt().toString(), "");
    }

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(() -> new UserNotFoundException(UserConstants.NOT_FOUND));
    }

    public void saveUser(User userEntity) {
        if(verifyIfUserExists(userEntity.getEmail())) {
            throw new UserAlreadyRegisteredException(UserConstants.ALREADY_REGISTERED);
        }
        userRepository.save(userEntity);
    }

    public void deleteUser(String id) {
        User userEntity = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(UserConstants.NOT_FOUND));
        userRepository.delete(userEntity);
    }

    private boolean verifyIfUserExists(String email) {
        return userRepository.findByEmail(email).isPresent();
    }
}
