package com.alex.telegramlongpollingbotexample.bot;

import com.alex.telegramlongpollingbotexample.handler.UpdateHandler;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

import javax.annotation.Resource;

@Component
public class LongPollingBot extends TelegramLongPollingBot {
    @Value("${telegram.bot.name}")
    private String userName;
    @Value("${telegram.bot.token}")
    private String userToken;
    @Resource
    private UpdateHandler updateHandler;

    @SneakyThrows
    @Override
    public void onUpdateReceived(Update update) {
        updateHandler.handle(update);
    }

    @Override
    public String getBotUsername() {
        return userName;
    }

    @Override
    public String getBotToken() {
        return userToken;
    }
}
