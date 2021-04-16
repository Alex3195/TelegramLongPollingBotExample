package com.alex.telegramlongpollingbotexample.commands;

import com.alex.telegramlongpollingbotexample.commands.impl.Command;
import com.alex.telegramlongpollingbotexample.commands.impl.Commands;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.FileNotFoundException;
import java.util.Locale;
@Service
public class BackCommand implements Command<Message> {

    @Override
    public void execute(Message response, Locale locale, String commands) throws TelegramApiException, FileNotFoundException {

    }
}
