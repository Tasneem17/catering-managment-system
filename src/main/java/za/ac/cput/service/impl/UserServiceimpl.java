package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.User;
import za.ac.cput.repository.UserRepository;
import za.ac.cput.service.UserService;

import java.util.Optional;

@Service
public class UserServiceimpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceimpl(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }
    @Override
    public User save(User user) {
        return this.userRepository.save(user);
    }

    @Override
    public Optional<User> read(String s) {
        return this.userRepository.findById(s);
    }

    @Override
    public void delete(User user) {
        this.userRepository.delete(user);
    }
}
