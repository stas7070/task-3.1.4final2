package ru.itmentor.spring.boot_security.demo.service;

import ru.itmentor.spring.boot_security.demo.model.User;

import java.util.List;

public interface UserService {
    void saveUser(User user);
    List<User> allUsers();
    void deleteUserById(Long id);
    void updateUser(Long id, User user);
    User getUserByEmail(String email);
}