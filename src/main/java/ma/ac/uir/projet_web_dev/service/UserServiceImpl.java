package ma.ac.uir.projet_web_dev.service;

import ma.ac.uir.projet_web_dev.dao.UserRepository;
import ma.ac.uir.projet_web_dev.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserServiceImpl implements UserService{
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository theUserRepository){
        this.userRepository = theUserRepository;
    }

    @Override
    public User save(User theUser) {
        return userRepository.save(theUser);
    }

    @Override
    public User findById(int theId) {
        Optional<User> result = userRepository.findById(theId);

        User theUser = null;

        if (result.isPresent()) {
            theUser = result.get();
        }
        else {
            throw new RuntimeException("!find user id - " + theId);
        }
        return theUser;
    }


}
