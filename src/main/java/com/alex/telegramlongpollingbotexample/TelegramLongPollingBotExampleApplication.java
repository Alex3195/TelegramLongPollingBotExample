package com.alex.telegramlongpollingbotexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.ApiContextInitializer;

@SpringBootApplication(scanBasePackages = "com.alex.telegramlongpollingbotexample")
public class TelegramLongPollingBotExampleApplication {

    public static void main(String[] args) {
        ApiContextInitializer.init();
        SpringApplication.run(TelegramLongPollingBotExampleApplication.class, args);
    }

}
