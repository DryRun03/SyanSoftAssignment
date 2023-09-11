package io.syansoft.repository;

import io.syansoft.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,String> {
    public Optional<User> findUserByEmail(String email);

    UserDetails findByUserName(String username);

}
