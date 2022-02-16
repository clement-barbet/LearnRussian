package fr.brbt.learnrussian.db;

import fr.brbt.learnrussian.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
