package study.eatgo.domain.user.dao;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import study.eatgo.domain.user.domain.User;
import study.eatgo.domain.user.model.Email;

public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByEmail(Email email);

    Optional<User> findByEmail(Email email);
}
