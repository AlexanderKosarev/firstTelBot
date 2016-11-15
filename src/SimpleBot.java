import java.util.ArrayList;
import java.util.List;

import org.telegram.telegrambots.TelegramApiException;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.api.methods.send.SendChatAction;
import org.telegram.telegrambots.api.methods.send.SendLocation;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.methods.send.SendPhoto;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardRow;

public class SimpleBot extends TelegramLongPollingBot {

    public static void main(String[] args) {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        try {
            telegramBotsApi.registerBot(new SimpleBot());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getBotUsername() {
        return "AlexKosarev_bot";
    }

    @Override
    public String getBotToken() {
        return "295268741:AAHqE9ctuIGVm3LDlcBb4_UGUTZpiUjJ1z4";
    }

//    @Override
//    public void onUpdateReceived(Update update) {
//        Message message = update.getMessage();
//        if (message != null && message.hasText()) {
//            if (message.getText().equals("/help"))
//                sendMsg(message, "Привет, я робот");
//            else
//                sendMsg(message, "Я не знаю что ответить на это");
//        }
//    }

    @Override
    public void onUpdateReceived(Update update) {
        Message message = update.getMessage();
        if (message != null && message.hasText()) {
                sendMsg(message);
        }
    }

//    private void sendMsg(Message message, String text) {
//        SendMessage sendMessage = new SendMessage();
//        sendMessage.enableMarkdown(true);
//        sendMessage.setChatId(message.getChatId().toString());
//        //sendMessage.setReplyToMessageId(message.getMessageId());
//        sendMessage.setText(text);
//        SendPhoto sendPhoto = new SendPhoto();
//        sendPhoto.setChatId(message.getChatId().toString());
//        sendPhoto.setPhoto("http://img1.joyreactor.cc/pics/post/Эротика-boobs-Сиськи-сиське-56189.jpeg");
//        try {
//            sendPhoto(sendPhoto);
//        } catch (TelegramApiException e) {
//            e.printStackTrace();
//        }
//
//        try {
//            sendMessage(sendMessage);
//        } catch (TelegramApiException e) {
//            e.printStackTrace();
//        }
//    }

    private void sendMsg(Message message) {

        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboad(false);
        sendMessage.setChatId(message.getChatId().toString());
        //sendMessage.setReplyToMessageId(message.getMessageId());
        sendMessage.setText("Привет");
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(message.getChatId().toString());
        sendPhoto.setPhoto("http://img1.joyreactor.cc/pics/post/Эротика-boobs-Сиськи-сиське-56189.jpeg");
        SendChatAction sendChatAction = new SendChatAction();
        sendChatAction.setChatId(message.getChatId().toString());
        sendChatAction.setAction("Action 1");
        SendLocation sendLocation = new SendLocation();
        sendLocation.setChatId(message.getChatId().toString());
        
        if (message.getText().equals("меню")){
            List<KeyboardRow> keyboard = new ArrayList<>();
            KeyboardRow keyboardFirstRow  = new KeyboardRow();
            keyboardFirstRow.add("пункт 1.1");
            keyboardFirstRow.add("пункт 1.2");
            keyboard.add(keyboardFirstRow);
            KeyboardRow keyboardSecondRow  = new KeyboardRow();
            keyboardFirstRow.add("пункт 2.1");
            keyboard.add(keyboardSecondRow);
            KeyboardRow keyboardThirdRow  = new KeyboardRow();
            keyboardFirstRow.add("пункт 3.1");
            keyboard.add(keyboardThirdRow);
            replyKeyboardMarkup.setKeyboard(keyboard);
        }
        try {
            sendPhoto(sendPhoto);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

        try {
            sendMessage(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

}

