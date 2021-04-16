package com.alex.telegramlongpollingbotexample.handler.impl;

import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.FileNotFoundException;

public interface Handler <T>{
    void handle(T t) throws TelegramApiException, FileNotFoundException;
}
