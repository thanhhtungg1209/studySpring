package com.example.testt.repository;

import com.example.testt.database.FakeDB;
import com.example.testt.exception.BadRequestException;
import com.example.testt.exception.NotFoundException;
import com.example.testt.model.PageUser;
import com.example.testt.model.User;
import com.example.testt.model.UserDto;
import com.example.testt.request.UpsertPasswordRequest;
import com.example.testt.request.UpsertUserRequest;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Repository
public class UserRepository {

    public List<User> findALl() {

        return FakeDB.users;
    }

    public List<UserDto> getUserByName(String name) {
        List<UserDto> result = new ArrayList<>();
        for (User user : FakeDB.users) {
            if (findName(user.getName()).equals(name)) {
                UserDto userDto = new UserDto(
                        user.getId(),
                        user.getName(),
                        user.getEmail(),
                        user.getPhone(),
                        user.getAddress(),
                        user.getAvatar()
                );
                result.add(userDto);
            }
        }
        return result;
    }

    private String findName(String name) {
        String[] strings = name.split(" ");
        return strings[strings.length - 1].trim().toLowerCase();
    }

    public Optional<User> getUserById(int id) {
        return FakeDB.users
                .stream()
                .filter(user -> user.getId() == id)
                .findFirst();
    }

    public User createUser(UpsertUserRequest request) {
        Random rd = new Random();
        int id = rd.nextInt(200);

        User user = new User(
                id,
                request.getName(),
                request.getEmail(),
                request.getPhone(),
                request.getAddress(),
                request.getAvatar(),
                request.getPassword()
        );
        FakeDB.users.add(user);
        return user;
    }

    private List<Integer> getAllID() {
        List<Integer> list = new ArrayList<>();
        for (User user : FakeDB.users) {
            list.add(user.getId());
        }
        return list;
    }

    public void updateUser(UpsertUserRequest request, int id) {
        User user = getUserById(id).orElseThrow(() -> {
            throw new NotFoundException("Not found user with " + id);
        });
        user.setName(request.getName());
        user.setAddress(request.getAddress());
        user.setPhone(request.getPhone());
    }

    public void deleteUser(int id) {
        FakeDB.users.removeIf(user -> user.getId() == id);
    }

    public void updateAvatar(UpsertUserRequest request, int id) {
        if (getUserById(id).isPresent()) {
            for (User user1 : FakeDB.users) {
                if (user1.getId() == id) {
                    user1.setAvatar(request.getAvatar());
                }
            }
        } else throw new NotFoundException("Not found exception with " + id);

    }

    public void updatePassword(UpsertPasswordRequest request, int id) {
        User user = getUserById(id).orElseThrow(() -> {
            throw new NotFoundException("Not found exception with " + id);
        });
        if (!request.getOldPassword().equals(user.getPassword()))
            throw new NotFoundException("M???t kh???u c?? kh??ng ch??nh x??c");
        if (request.getOldPassword().equals(request.getNewPassword()))
            throw new BadRequestException("M???t kh???u m???i gi???ng m???t kh???u c?? ");
        for (User user1 : FakeDB.users) {
            if (user1.getId() == id) {
                user.setPassword(request.getNewPassword());
            }
        }
    }

    public String forgotPassword(int id) {
        User user = getUserById(id).orElseThrow(() -> {
            throw new NotFoundException("Not found exception with " + id);
        });
        user.setPassword(user.getPassword() + '1');
        return user.getPassword();
    }

    public PageUser getPageUser(int page, int limit) {
        int totalPage = (FakeDB.users.size() / limit) + 1;
        int size = limit;
        int currentPage = page;
        int n = (page - 1) * limit;
        List<User> list = new ArrayList<>();
        while (n < Math.min(FakeDB.users.size() - (page - 1) * limit, limit)) {
            list.add(FakeDB.users.get(n));
            n++;
        }
        return new PageUser(list, currentPage, size, totalPage);
    }
}
