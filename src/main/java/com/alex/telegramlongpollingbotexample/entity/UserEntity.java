package com.alex.telegramlongpollingbotexample.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "users")
public class UserEntity {
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String userName;
    private String firstName;
    private String lastName;
    private Timestamp createdTime;
    private String languageCode;
}
