package ma.ac.uir.projet_web_dev.service;

import ma.ac.uir.projet_web_dev.entity.User;



public interface UserService {
    User save(User theUser);
    User findById(int theId);


}
