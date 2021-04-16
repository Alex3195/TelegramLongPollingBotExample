package com.alex.telegramlongpollingbotexample.commands.impl;

import com.alex.telegramlongpollingbotexample.utils.KeyBoardUtils;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public final class Commands {
    public static final String START_COMMAND = "/start";
    public static final String PHOTO = "photo";
    public static final String DOC = "document";
    public static final String VIDEO = "video";
    public static final String MP3 = "mp3";

    public static final String CATALOG_COMMAND = "\uD83D\uDCE6 Catalog";
    public static final String CART_COMMAND = "\uD83D\uDECD Cart";
    public static final String SETTING_COMMAND = "\uD83D\uDECD Cart";

    public static final String LANGUAGE_UZ = "\uD83C\uDDFA\uD83C\uDDFF O'zbekcha";
    public static final String LANGUAGE_RU = "\uD83C\uDDF7\uD83C\uDDFA Русский";
    public static final String LANGUAGE_EN = "\ud83C\uDDFA\uD83C\uDDF8 English";

    public static final String ORDER_NEXT_STEP_COMMAND = "\u2714\uFE0F Correct";
    public static final String ORDER_PREVIOUS_STEP_COMMAND = "\u25C0 Back";
    public static final String ORDER_CANCEL_COMMAND = "\u274C Cancel order";

    private Commands() {
    }

//    public static ReplyKeyboardMarkup createGeneralMenuKeyboard(Locale locale) {
//        ResourceBundle bundle = R.bundle(locale);
//        return KeyboardUtils.create(new ArrayList<KeyboardRow>() {{
//            add(new KeyboardRow() {{
//                add(bundle.getString("label.section.about.company"));
//            }});
//            add(new KeyboardRow() {{
//                add(bundle.getString("label.section.vacancies"));
//                add(bundle.getString("label.section.contacts"));
//            }});
//            add(new KeyboardRow() {{
//                add(bundle.getString("label.leave.feedback"));
//                add(bundle.getString("label.command.settings"));
//            }});
//        }});
//    }

    public static InlineKeyboardMarkup getInlineKeyboardMarkup() {
        InlineKeyboardMarkup markup = new InlineKeyboardMarkup();
        InlineKeyboardButton buttonYes = new InlineKeyboardButton().setText("Yes");
        InlineKeyboardButton buttonNo = new InlineKeyboardButton().setText("No");
        InlineKeyboardButton buttonIwillThink = new InlineKeyboardButton().setText("I will think.");
        InlineKeyboardButton buttonIdontKnow = new InlineKeyboardButton().setText("I don't konw yet.");

        buttonYes.setCallbackData("buttonYes");
        buttonNo.setCallbackData("buttonNo");
        buttonIdontKnow.setCallbackData("buttonIdontKnow");
        buttonIwillThink.setCallbackData("buttonIwillThink");

        List<InlineKeyboardButton> row1 = new ArrayList<>();
        row1.add(buttonYes);
        row1.add(buttonNo);

        List<InlineKeyboardButton> row2 = new ArrayList<>();
        row2.add(buttonIwillThink);
        row2.add(buttonIdontKnow);

        List<List<InlineKeyboardButton>> rows = new ArrayList<>();
        rows.add(row1);
        rows.add(row2);
        markup.setKeyboard(rows);
        return markup;
    }

    public static ReplyKeyboardMarkup getShareContractKeyBoard() {
        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setResizeKeyboard(true);
        markup.setSelective(true);
        markup.setOneTimeKeyboard(true);

        List<KeyboardRow> rows = new ArrayList<>();

        KeyboardRow row = new KeyboardRow();
        KeyboardButton askSherContact = new KeyboardButton();
        askSherContact.setRequestContact(true);
        askSherContact.setText("Please share your contact.");
        row.add(askSherContact);
        rows.add(row);
        markup.setKeyboard(rows);
        return markup;
    }

    public static ReplyKeyboardMarkup getReplyKeyboardMarkup() {
        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setSelective(true);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);

        List<KeyboardRow> keyboard = new ArrayList<>();

        KeyboardRow row = new KeyboardRow();
        KeyboardRow row1 = new KeyboardRow();
        KeyboardRow row2 = new KeyboardRow();
        KeyboardRow row3 = new KeyboardRow();

        KeyboardButton button = new KeyboardButton();
        KeyboardButton button1 = new KeyboardButton();
        KeyboardButton button2 = new KeyboardButton();
        KeyboardButton button3 = new KeyboardButton();

        button.setText("photo");
        button1.setText("document");
        button2.setText("video");
        button3.setText("mp3");

        row.add(button);
        row1.add(button1);
        row2.add(button2);
        row3.add(button3);

        keyboard.add(row);
        keyboard.add(row1);
        keyboard.add(row2);
        keyboard.add(row3);

        markup.setKeyboard(keyboard);

        return markup;
    }
}
