package ma.ac.uir.projet_web_dev.service;

import ma.ac.uir.projet_web_dev.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User save(User theUser);
    User findById(int theId);


}
