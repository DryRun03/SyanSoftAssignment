package io.syansoft.repository;

import io.syansoft.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,String> {
    public Optional<User> findUserByEmail(String email);
}
