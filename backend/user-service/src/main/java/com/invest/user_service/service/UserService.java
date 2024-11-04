package com.invest.user_service.service;

import com.invest.user_service.DTO.UserDTO;
import com.invest.user_service.exception.BadRequestException;
import com.invest.user_service.exception.NotFoundException;
import com.invest.user_service.model.User;
import com.invest.user_service.repository.UserRepository;
import com.invest.user_service.util.UserMapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.Map;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Autowired
    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public User createUser(@Validated UserDTO userDTO) {
        if (userDTO.email() == null || userDTO.password() == null || userDTO.documentId() == null) {
            throw new BadRequestException("Email, senha e documento são obrigatórios.");
        }
        User user = userMapper.toEntity(userDTO);
        return userRepository.save(user);

    }

    public User findUserByEmail(String email) {
        validateEmail(email);
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new NotFoundException("Usuário com o email fornecido não encontrado."));
    }

    public User findUserById(long id) {
        validateId(id);
        return userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Usuário com o ID fornecido não encontrado."));
    }

    @Transactional
    public User updateUser(long id, UserDTO userDTO) {
        validateId(id);
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Usuário não encontrado!"));
        userMapper.updateUserFromDto(userDTO, existingUser);
        return userRepository.save(existingUser);
    }


    @Transactional
    public User updateUserPartial(Long id, UserDTO updates) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Usuário não encontrado!"));
        userMapper.updateUserFromDto(updates, existingUser);
        return userRepository.save(existingUser);
    }

    public void deleteUser(long id) {
        validateId(id);
        User user = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Usuário não encontrado!"));
        userRepository.delete(user);
    }

    private void validateEmail(String email) {
        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("Email não pode ser nulo ou vazio.");
        }
    }

    private void validateId(long id) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID inválido.");
        }
    }
}
