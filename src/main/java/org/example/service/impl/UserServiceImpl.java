package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.Entity.User;
import org.example.repository.UserRepository;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    final UserRepository userRepository;
    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }
}
