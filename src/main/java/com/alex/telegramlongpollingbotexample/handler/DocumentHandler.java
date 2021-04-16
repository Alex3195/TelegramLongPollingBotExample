package com.alex.telegramlongpollingbotexample.handler;

import com.alex.telegramlongpollingbotexample.handler.impl.Handler;
import com.alex.telegramlongpollingbotexample.model.MessageSend;
import com.alex.telegramlongpollingbotexample.service.TelegramService;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import javax.annotation.Resource;

@Service
public class DocumentHandler implements Handler<Message> {
    @Resource
    private TelegramService telegramService;

    @Override
    public void handle(Message message) throws TelegramApiException {
        Long chatId = message.getChatId();
        String text = message.getText();
        telegramService.sendMessage(new MessageSend(chatId,text));
    }
}
