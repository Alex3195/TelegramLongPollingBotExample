package com.alex.telegramlongpollingbotexample.commands.impl;

import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.FileNotFoundException;
import java.util.Locale;

public interface Command <T>{
    void execute(T response, Locale locale,String commands) throws TelegramApiException, FileNotFoundException;
}
