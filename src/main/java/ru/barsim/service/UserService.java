package ru.barsim.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.barsim.dto.User;
import ru.barsim.repository.UserRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers(){return userRepository.getAllUsers();}

    public User getUserInDay(User user, LocalDate date) {
        return userRepository.getUserInDay(user, date);
    }

    public
}
