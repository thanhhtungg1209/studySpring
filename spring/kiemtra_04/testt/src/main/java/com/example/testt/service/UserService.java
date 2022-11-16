package com.example.testt.service;

import com.example.testt.model.PageUser;
import com.example.testt.model.UserDto;
import com.example.testt.exception.NotFoundException;
import com.example.testt.model.User;
import com.example.testt.repository.UserRepository;
import com.example.testt.request.UpsertPasswordRequest;
import com.example.testt.request.UpsertUserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {


    @Autowired
    private UserRepository userRepository;


    public List<UserDto> getUserByName(String name) {
        return userRepository.getUserByName(name);
    }

    public UserDto findUserById(int id) {
        if (userRepository.getUserById(id).isPresent()) {
            UserDto userDto = new UserDto(
                    userRepository.getUserById(id).get().getId(),
                    userRepository.getUserById(id).get().getName(),
                    userRepository.getUserById(id).get().getEmail(),
                    userRepository.getUserById(id).get().getPhone(),
                    userRepository.getUserById(id).get().getAddress(),
                    userRepository.getUserById(id).get().getAvatar()
            );

            return userDto;
        } else throw new NotFoundException("Not found exception with " + id);
    }

    public UserDto createUser(UpsertUserRequest request) {
        UserDto userDto = new UserDto(
                userRepository.createUser(request).getId(),
                userRepository.createUser(request).getName(),
                userRepository.createUser(request).getEmail(),
                userRepository.createUser(request).getPhone(),
                userRepository.createUser(request).getAddress(),
                userRepository.createUser(request).getAvatar()
        );
        return userDto;
    }

    public UserDto updateUser(UpsertUserRequest request, int id) {
        userRepository.updateUser(request, id);
        return findUserById(id);
    }

    public void deleteUser(int id) {
        userRepository.deleteUser(id);
    }

    public List<User> findAll() {
        return userRepository.findALl();
    }

    public void updateAvatar(UpsertUserRequest request, int id) {
        userRepository.updateAvatar(request, id);
    }

    public void updatePassword(UpsertPasswordRequest request, int id) {
        userRepository.updatePassword(request, id);
    }

    public String forgotPassword(int id) {
        return userRepository.forgotPassword(id);
    }

    public PageUser getPageUser(int page, int limit) {
        return userRepository.getPageUser(page, limit);
    }

}
