package ru.barsim.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.barsim.dto.User;
import ru.barsim.repository.UserRepository;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User getUser(Long id){return userRepository.getUser(id);}

    public List<User> getAllUsers(){return userRepository.getAllUsers();}
}
