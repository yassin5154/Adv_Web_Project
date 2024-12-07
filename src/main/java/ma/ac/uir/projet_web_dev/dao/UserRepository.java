package ma.ac.uir.projet_web_dev.dao;

import ma.ac.uir.projet_web_dev.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository <User, Integer> {

    Optional<User> findByLogin(String login);
}
