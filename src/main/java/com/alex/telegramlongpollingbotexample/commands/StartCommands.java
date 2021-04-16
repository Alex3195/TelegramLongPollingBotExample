package com.alex.telegramlongpollingbotexample.commands;


import com.alex.telegramlongpollingbotexample.commands.impl.Command;
import com.alex.telegramlongpollingbotexample.commands.impl.Commands;
import com.alex.telegramlongpollingbotexample.model.MessageSend;
import com.alex.telegramlongpollingbotexample.service.TelegramService;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import javax.annotation.Resource;
import java.util.Locale;
@Service
public class StartCommands implements Command<Long> {
    @Resource
    private TelegramService telegramService;


    @Override
    public void execute(Long chatId, Locale locale, String commands) throws TelegramApiException {
        telegramService.sendMessage(new MessageSend(chatId, "Please share your cotact", Commands.getShareContractKeyBoard()));

    }
}
