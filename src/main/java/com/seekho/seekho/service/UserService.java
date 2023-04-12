package com.seekho.seekho.service;

import com.seekho.seekho.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    public User addUser(User user);

    public List<User> getUsers();

    public User getUserByUserID(int userId);
}
