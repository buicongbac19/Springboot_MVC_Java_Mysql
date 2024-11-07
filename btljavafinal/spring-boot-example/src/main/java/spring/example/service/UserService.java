//package com.yourpackage.service;
package spring.example.service;
import spring.example.model.User;

import spring.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Lấy tất cả người dùng
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Lấy người dùng theo id
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    // Tạo người dùng mới
    public User createUser(User user) {
        return userRepository.save(user);
    }

    // Cập nhật người dùng
    public User updateUser(Long id, User userDetails) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            User existingUser = user.get();
            existingUser.setUsername(userDetails.getUsername());
            existingUser.setEmail(userDetails.getEmail());
            existingUser.setPassword(userDetails.getPassword());
            return userRepository.save(existingUser);
        }
        return null; // Hoặc throw exception nếu không tìm thấy user
    }

    // Xóa người dùng
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
