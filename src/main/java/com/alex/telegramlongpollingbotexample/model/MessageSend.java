package com.alex.telegramlongpollingbotexample.model;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;

public class MessageSend {
    private final Long chatId;
    private final String text;
    private final ReplyKeyboard replyKeyboar;

    public MessageSend(Long chatId, String text) {
        this.chatId = chatId;
        this.text = text;
        this.replyKeyboar = null;
    }

    public MessageSend(Long chatId, String text, ReplyKeyboard languageKeyboard) {
        this.chatId = chatId;
        this.text = text;
        this.replyKeyboar = languageKeyboard;
    }

    public Long getChatId() {
        return chatId;
    }

    public String getText() {
        return text;
    }

    public ReplyKeyboard getReplyKeyboardMarkup() {
        return replyKeyboar;
    }
}
