package com.alex.telegramlongpollingbotexample.handler;

import com.alex.telegramlongpollingbotexample.handler.impl.Handler;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Message;
@Service
public class ActionHandler implements Handler<Message> {
    @Override
    public void handle(Message message) {

    }
}
