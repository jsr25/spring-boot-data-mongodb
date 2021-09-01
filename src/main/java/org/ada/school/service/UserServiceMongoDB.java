package org.ada.school.service;

import org.ada.school.dto.UserDto;
import org.ada.school.model.User;
import org.ada.school.model.UserDocument;
import org.ada.school.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserServiceMongoDB implements UserService {

    private final UserRepository userRepository;

    public UserServiceMongoDB(@Autowired UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User create(User user) {
        UserDocument userDocument = userRepository.save(new UserDocument(user));
        return new User(userDocument);
    }

    @Override
    public User findById(String id) {
        Optional<UserDocument> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            return new User(optionalUser.get());
        }
        return null;
    }

    @Override
    public List<User> all() {
        List<User> listUser = new ArrayList<>();
        List<UserDocument> list = userRepository.findAll();
        for (UserDocument usd : list) {
            listUser.add(new User(usd));
        }
        return listUser;
    }

    @Override
    public boolean deleteById(String id) {
        return false;
    }

    @Override
    public User update(UserDto userDto, String id) {
        return null;
    }
}
