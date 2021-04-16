package com.alex.telegramlongpollingbotexample.service;

import com.alex.telegramlongpollingbotexample.entity.UserEntity;
import com.alex.telegramlongpollingbotexample.model.User;
import com.alex.telegramlongpollingbotexample.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User findById(Long id) {
        Optional<UserEntity> userEntity = userRepository.findById(id);
        return userEntity.map(this::convertToUser).orElse(null);
    }

    public User save(User user) {
        UserEntity entity = userRepository.save(convertToUserEntity(user));
        return convertToUser(entity);
    }

    private UserEntity convertToUserEntity(User user) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUserName(user.getUserName());
        userEntity.setFirstName(user.getFirstName());
        userEntity.setLastName(user.getLastName());
        userEntity.setLanguageCode(user.getLanguage());
        userEntity.setId(user.getId());
        Timestamp timestamp = Timestamp.valueOf(user.getCreateDate());
        userEntity.setCreatedTime(timestamp);
        return userEntity;
    }

    private User convertToUser(UserEntity userEntity) {
        User user = new User();
        user.setId(userEntity.getId());
        user.setUserName(userEntity.getUserName());
        user.setFirstName(userEntity.getFirstName());
        user.setLastName(userEntity.getLastName());
        user.setLanguage(userEntity.getLanguageCode());
        String createdDate = userEntity.getCreatedTime().toString();
        user.setCreateDate(createdDate);
        return user;
    }
}
