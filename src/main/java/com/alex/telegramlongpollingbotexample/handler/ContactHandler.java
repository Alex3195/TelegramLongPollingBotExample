package com.alex.telegramlongpollingbotexample.handler;

import com.alex.telegramlongpollingbotexample.commands.impl.Commands;
import com.alex.telegramlongpollingbotexample.handler.impl.Handler;
import com.alex.telegramlongpollingbotexample.model.MessageSend;
import com.alex.telegramlongpollingbotexample.model.User;
import com.alex.telegramlongpollingbotexample.service.TelegramService;
import com.alex.telegramlongpollingbotexample.service.UserService;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class ContactHandler implements Handler<Message> {
    @Resource
    private TelegramService telegramService;
    @Resource
    private UserService userService;

    @Override
    public void handle(Message message) throws TelegramApiException {
        Long chatId = message.getChatId();
        User client = new User();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.now();
        String creaeDate = formatter.format(localDateTime);
        client = new User();
        client.setId(message.getFrom().getId().longValue());
        client.setCreateDate(creaeDate);
        client.setFirstName(message.getFrom().getFirstName());
        client.setLastName(message.getFrom().getLastName());
        client.setUserName(message.getFrom().getUserName());
        client.setLanguage(message.getFrom().getLanguageCode());
        client.setPhone(message.getContact().getPhoneNumber());
        userService.save(client);
        telegramService.sendMessage(new MessageSend(chatId, "text", Commands.getReplyKeyboardMarkup()));
    }
}
