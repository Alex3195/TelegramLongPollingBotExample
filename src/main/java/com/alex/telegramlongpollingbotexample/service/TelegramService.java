package com.alex.telegramlongpollingbotexample.service;

import com.alex.telegramlongpollingbotexample.model.MessageSend;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.telegram.telegrambots.bots.DefaultAbsSender;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.meta.ApiContext;
import org.telegram.telegrambots.meta.api.methods.send.*;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Field;

@Service
public class TelegramService extends DefaultAbsSender {

    @Value("${telegram.bot.token}")
    private String token;

    protected TelegramService() {
        super(ApiContext.getInstance(DefaultBotOptions.class));
    }

    public Message sendMessage(MessageSend message) throws TelegramApiException {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(message.getChatId());
        sendMessage.setText(message.getText());
        sendMessage.setReplyMarkup(message.getReplyKeyboardMarkup());

        try {
            return execute(sendMessage);
        } catch (TelegramApiException e) {
            throw new TelegramApiException(String.format("Failed send text message %s", message), e);
        }
    }

    public Message sendDocumnet(MessageSend messageSend,String imagePath,String caption) throws TelegramApiException, FileNotFoundException {
        File doc = ResourceUtils.getFile(imagePath);
        SendDocument sendDocument = new SendDocument();
        sendDocument.setChatId(messageSend.getChatId());
        sendDocument.setCaption(caption);
        sendDocument.setDocument(doc);
        return execute(sendDocument);
    }

    public Message sendPhoto(MessageSend messageSend, String imgCaption, String imgPath) throws FileNotFoundException, TelegramApiException {
        File img = ResourceUtils.getFile(imgPath);
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(messageSend.getChatId());
        sendPhoto.setCaption(imgCaption);
        sendPhoto.setPhoto(img);
        return execute(sendPhoto);
    }

    public Message sendVideo(MessageSend messageSend,String path,String caption) throws FileNotFoundException, TelegramApiException {
        File video = ResourceUtils.getFile(path);
        SendVideo sendVideo = new SendVideo();
        sendVideo.setChatId(messageSend.getChatId());
        sendVideo.setCaption(caption);
        sendVideo.setVideo(video);
        return execute(sendVideo);
    }

    public Message sendAudio(MessageSend messageSend,String path,String caption) throws FileNotFoundException, TelegramApiException {
        SendAudio sendAudio = new SendAudio();
        File audio = ResourceUtils.getFile(path);
        sendAudio.setChatId(messageSend.getChatId());
        sendAudio.setCaption(caption);
        sendAudio.setAudio(audio);
        return execute(sendAudio);
    }

    @Override
    public String getBotToken() {
        return token;
    }
}
