package com.alex.telegramlongpollingbotexample.model;

import lombok.Data;

import java.util.Locale;
@Data
public class User {
    private Long id;
    private String telegramId;
    private String phone;
    private String firstName;
    private String lastName;
    private String userName;
    private String language;
    private String createDate;

    public Locale getLocale() {
        return language != null ? new Locale(language) : Locale.getDefault();
    }
}
