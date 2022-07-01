package com.inventorycontrol.service;

import com.inventorycontrol.exception.UserNotFoundException;
import com.inventorycontrol.model.UserModel;
import com.inventorycontrol.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    private BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public List<UserModel> findAll() {
        return userRepository.findAll();
    }

    public UserModel findById(UUID uuid) {
        return userRepository.findById(uuid).orElseThrow(() -> new UserNotFoundException("Usuário não encontrado."));
    }

    public UserModel save(UserModel userModel) {
        userModel.setPassword(passwordEncoder().encode(userModel.getPassword()));
        return userRepository.save(userModel);
    }

    public UserModel update(UserModel userModel, UUID uuid) {
        userRepository.findById(uuid).orElseThrow(() -> new UserNotFoundException("Usuário não encontrado."));
        userModel.setCodUser(uuid);
        userModel.setPassword(passwordEncoder().encode(userModel.getPassword()));
        userRepository.save(userModel);
        return userModel;
    }

    public UUID delete(UUID uuid) {
        var userModel = userRepository.findById(uuid).orElseThrow(() -> new UserNotFoundException("Usuário não encontrado."));
        userRepository.delete(userModel);
        return uuid;
    }
}
