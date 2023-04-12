package com.seekho.seekho.dao;

import com.seekho.seekho.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
