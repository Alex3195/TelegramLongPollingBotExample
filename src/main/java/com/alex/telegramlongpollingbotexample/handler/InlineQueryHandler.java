package com.alex.telegramlongpollingbotexample.handler;

import com.alex.telegramlongpollingbotexample.handler.impl.Handler;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.inlinequery.InlineQuery;
@Service
public class InlineQueryHandler implements Handler<InlineQuery> {
    @Override
    public void handle(InlineQuery inlineQuery) {

    }
}
