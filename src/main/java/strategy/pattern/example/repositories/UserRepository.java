package strategy.pattern.example.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import strategy.pattern.example.models.User;

public interface UserRepository extends JpaRepository<User, Integer> {
}
