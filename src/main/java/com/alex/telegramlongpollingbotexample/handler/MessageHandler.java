package com.alex.telegramlongpollingbotexample.handler;

import com.alex.telegramlongpollingbotexample.commands.GeneralCommand;
import com.alex.telegramlongpollingbotexample.commands.StartCommands;
import com.alex.telegramlongpollingbotexample.commands.impl.Commands;
import com.alex.telegramlongpollingbotexample.handler.impl.Handler;
import com.alex.telegramlongpollingbotexample.model.MessageSend;
import com.alex.telegramlongpollingbotexample.model.User;
import com.alex.telegramlongpollingbotexample.service.TelegramService;
import com.alex.telegramlongpollingbotexample.service.UserService;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import javax.annotation.Resource;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class MessageHandler implements Handler<Message> {
    @Resource
    private TelegramService telegramService;
    @Resource
    private StartCommands startCommand;
    @Resource
    private GeneralCommand generalCommand;
    @Resource
    private UserService userService;

    @Override
    public void handle(Message message) throws TelegramApiException, FileNotFoundException {
        Long chatId = message.getChatId();
        String text = message.getText();
        User client = null;
        Boolean userIsExists = false;
        if (message.getFrom() != null) {
            client = userService.findById(message.getFrom().getId().longValue());
        }

        if (text.startsWith(Commands.START_COMMAND) || client == null) {
            startCommand.execute(chatId, client != null ? client.getLocale() : null, Commands.START_COMMAND);
            return;
        }
        switch (text) {
            case Commands.PHOTO:
                generalCommand.execute(chatId, client.getLocale(), Commands.PHOTO);
                break;
            case Commands.DOC:
                generalCommand.execute(chatId, client.getLocale(), Commands.DOC);
                break;
            case Commands.VIDEO:
                generalCommand.execute(chatId, client.getLocale(), Commands.VIDEO);
                break;
            case Commands.MP3:
                generalCommand.execute(chatId, client.getLocale(), Commands.MP3);
                break;
            default:
                telegramService.sendMessage(new MessageSend(chatId, text, Commands.getReplyKeyboardMarkup()));
                break;
        }
        return;
    }

}
