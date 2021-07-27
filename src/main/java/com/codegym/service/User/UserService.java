package com.codegym.service.User;

import com.codegym.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserService implements IUserService {
    @Autowired
    private IUserService userService;
    @Override
    public Iterable<User> findAll() {
       return userService.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        return userService.findById(id);
    }

    @Override
    public void save(User user) {
    userService.save(user);
    }

    @Override
    public void delete(Long id) {
        userService.delete(id);
    }
}
