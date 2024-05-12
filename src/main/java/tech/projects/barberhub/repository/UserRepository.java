package tech.projects.barberhub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.projects.barberhub.model.entity.user.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findByEmail(String email);
}