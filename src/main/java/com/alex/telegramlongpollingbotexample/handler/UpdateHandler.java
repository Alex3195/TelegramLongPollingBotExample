package com.alex.telegramlongpollingbotexample.handler;

import com.alex.telegramlongpollingbotexample.handler.impl.Handler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.FileNotFoundException;

@Service
@RequiredArgsConstructor
public class UpdateHandler implements Handler<Update> {
    private final MessageHandler messageHandler;
    private final ActionHandler actionHandler;
    private final CallBackHandler callBackHandler;
    private final InlineQueryHandler inlineQueryHandler;
    private final ContactHandler contactHandler;
    private final DocumentHandler documentHandler;

    @Override
    public void handle(Update update) throws TelegramApiException, FileNotFoundException {
        if (update.hasMessage()) {
            Message message = update.getMessage();
            if (message.hasText()) {
                messageHandler.handle(message);
            }else if (message.hasContact()){
                contactHandler.handle(message);
            }else if (message.hasDocument()){
                documentHandler.handle(message);
            }else if (update.hasInlineQuery()){
                inlineQueryHandler.handle(update.getInlineQuery());
            }else if (update.hasCallbackQuery()){
                callBackHandler.handle(update.getCallbackQuery());
            }
        }
    }
}
