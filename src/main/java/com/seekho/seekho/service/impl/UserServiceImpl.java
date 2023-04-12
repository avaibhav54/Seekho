package com.seekho.seekho.service.impl;

import com.seekho.seekho.dao.UserRepository;
import com.seekho.seekho.exception.SeekhoException;
import com.seekho.seekho.model.User;
import com.seekho.seekho.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public User addUser(User user) {
        try{
        return this.userRepository.save(user);
        }catch (Exception e)
        {
            throw new SeekhoException("code","This Plan Doesn't exist");
        }
    }

    @Override
    public List<User> getUsers() {
        return this.userRepository.findAll();
    }

    @Override
    public User getUserByUserID(int userId) {
        Optional<User> userOptional = this.userRepository.findById(userId);
        return userOptional.orElse(null);
    }
}
