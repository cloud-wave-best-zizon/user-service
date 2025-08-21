package com.cloudwave.best_zizon.domain.user.repository;

import com.cloudwave.best_zizon.domain.user.domain.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    Boolean existsByLoginId(String loginId);

    Optional<User> findByLoginIdAndPassword(String loginId, String password);
}
