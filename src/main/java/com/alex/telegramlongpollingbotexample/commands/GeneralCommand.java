package com.alex.telegramlongpollingbotexample.commands;

import com.alex.telegramlongpollingbotexample.commands.impl.Command;
import com.alex.telegramlongpollingbotexample.commands.impl.Commands;
import com.alex.telegramlongpollingbotexample.model.MessageSend;
import com.alex.telegramlongpollingbotexample.service.TelegramService;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import javax.annotation.Resource;
import java.io.FileNotFoundException;
import java.util.Locale;
@Service
public class GeneralCommand implements Command<Long> {
    @Resource
    private TelegramService service;


    @Override
    public void execute(Long chatId, Locale locale, String commands) throws TelegramApiException, FileNotFoundException {
        if(commands.equals(Commands.PHOTO)){
            service.sendPhoto(new MessageSend(chatId,""),"","/home/alex/project/TelegramLongPollingBotExample/src/main/resources/static/img/anna-wangler-_GqwoiT7QY8-unsplash.jpg");
        }
        if (commands.equals(Commands.DOC)){
            service.sendDocumnet(new MessageSend(chatId, ""),"/home/alex/project/TelegramLongPollingBotExample/src/main/resources/static/doc/Linuxdagi hisoblar.pptx","This is my doc files");
        }
        if (commands.equals(Commands.VIDEO)){
            service.sendVideo(new MessageSend(chatId,"hi"),"/home/alex/Downloads/Telegram Desktop/IMG_5183.mp4","test video");
        }
        if (commands.equals(Commands.MP3)){
            service.sendAudio(new MessageSend(chatId,""),"/home/alex/Downloads/SHakira – Underneath your clothes старая.mp3","favorite song");
        }

    }
}
