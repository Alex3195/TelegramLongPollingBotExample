package com.alex.telegramlongpollingbotexample.handler;

import com.alex.telegramlongpollingbotexample.handler.impl.Handler;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
@Service
public class CallBackHandler implements Handler<CallbackQuery> {
    @Override
    public void handle(CallbackQuery callbackQuery) {
        long chatId = callbackQuery.getMessage().getChatId();
        long userId = callbackQuery.getFrom().getId();

    }
}
