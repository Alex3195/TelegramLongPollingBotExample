package com.alex.telegramlongpollingbotexample.repository;

import com.alex.telegramlongpollingbotexample.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.annotation.Resource;

@Resource
public interface UserRepository extends JpaRepository<UserEntity,Long> {
}
