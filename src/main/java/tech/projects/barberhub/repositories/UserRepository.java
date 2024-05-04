package tech.projects.barberhub.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.projects.barberhub.model.entities.user.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findByEmail(String email);
}