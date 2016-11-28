import java.util.ArrayList;
import java.util.List;

import org.telegram.telegrambots.TelegramApiException;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.api.methods.send.SendChatAction;
import org.telegram.telegrambots.api.methods.send.SendLocation;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.methods.send.SendPhoto;
import org.telegram.telegrambots.api.objects.CallbackQuery;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.api.objects.replykeyboard.ForceReplyKeyboard;
import org.telegram.telegrambots.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardHide;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardButton;
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



    @Override
    public void onUpdateReceived(Update update) {
        Message message = update.getMessage();
        if (message != null && message.hasText()) {
            try {
                sendMsg(message);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }




    private void sendMsg(Message message) throws TelegramApiException {

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
        CallbackQuery callbackQuery = new CallbackQuery();
        try {


            if (callbackQuery.getData().toString().equals(null)) {
                System.out.print("Null");
            } else if (callbackQuery.getData().toString().equals("лол")) {
                sendMessage.setText("ОНО ЖИВО");
            }
        }catch (Exception e)
        {

        }
//        SendChatAction sendChatAction = new SendChatAction();
//        sendChatAction.setChatId(message.getChatId().toString());
//        sendChatAction.setAction("Action 1");
        SendLocation sendLocation = new SendLocation();
        sendLocation.setChatId(message.getChatId().toString());
        if (message.getText().equals("кнопки") || message.getText().equals("Кнопки")){
            sendKeyboard(message);
        }
        
//        if (message.getText().equals("меню") || message.getText().equals("Меню")){
//            List<KeyboardRow> keyboard = new ArrayList<>();
//            KeyboardRow keyboardFirstRow  = new KeyboardRow();
//            keyboardFirstRow.add("пункт 1.1");
//            keyboardFirstRow.add("пункт 1.2");
//            keyboard.add(keyboardFirstRow);
//            KeyboardRow keyboardSecondRow  = new KeyboardRow();
//            keyboardSecondRow.add("пункт 2.1");
//            keyboard.add(keyboardSecondRow);
//            KeyboardRow keyboardThirdRow  = new KeyboardRow();
//            keyboardThirdRow.add("пункт 3.1");
//            keyboard.add(keyboardThirdRow);
//            replyKeyboardMarkup.setKeyboard(keyboard);
//
//        }
        try {
            sendMessage(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private void sendKeyboard(Message message) throws TelegramApiException {
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(message.getChatId().toString());
        sendMessage.setText("Держи");
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        sendMessage.setReplyMarkup(inlineKeyboardMarkup);
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        List<InlineKeyboardButton> inlineKeyboardButtons = new ArrayList<>();
        InlineKeyboardButton inlineKeyboardButton = new InlineKeyboardButton();
        inlineKeyboardButton.setText("Обеды (с 12 до 16 по будням)");
        inlineKeyboardButton.setUrl("https://core.telegram.org/bots/api#inlinekeyboardmarkup");
        inlineKeyboardButtons.add(inlineKeyboardButton);
        keyboard.add(inlineKeyboardButtons);
        inlineKeyboardButtons = new ArrayList<>();
        inlineKeyboardButton = new InlineKeyboardButton();
        inlineKeyboardButton.setText("Блинчики");
        inlineKeyboardButton.setCallbackData("лол");
        inlineKeyboardButtons.add(inlineKeyboardButton);
        keyboard.add(inlineKeyboardButtons);
        inlineKeyboardButtons = new ArrayList<>();
        inlineKeyboardButton = new InlineKeyboardButton();
        inlineKeyboardButton.setText("Трио пицца");
        inlineKeyboardButton.setUrl("https://core.telegram.org/bots/api#inlinekeyboardmarkup");
        inlineKeyboardButtons.add(inlineKeyboardButton);
        keyboard.add(inlineKeyboardButtons);
        inlineKeyboardButtons = new ArrayList<>();
        inlineKeyboardButton = new InlineKeyboardButton();
        inlineKeyboardButton.setText("Yes! Pizza");
        inlineKeyboardButton.setUrl("https://core.telegram.org/bots/api#inlinekeyboardmarkup");
        inlineKeyboardButtons.add(inlineKeyboardButton);
        keyboard.add(inlineKeyboardButtons);
        inlineKeyboardButtons = new ArrayList<>();
        inlineKeyboardButton = new InlineKeyboardButton();
        inlineKeyboardButton.setText("Роллы");
        inlineKeyboardButton.setUrl("https://core.telegram.org/bots/api#inlinekeyboardmarkup");
        inlineKeyboardButtons.add(inlineKeyboardButton);
        keyboard.add(inlineKeyboardButtons);
        inlineKeyboardButtons = new ArrayList<>();
        inlineKeyboardButton = new InlineKeyboardButton();
        inlineKeyboardButton.setText("Рис и лапша");
        inlineKeyboardButton.setUrl("https://core.telegram.org/bots/api#inlinekeyboardmarkup");
        inlineKeyboardButtons.add(inlineKeyboardButton);
        keyboard.add(inlineKeyboardButtons);
        inlineKeyboardButtons = new ArrayList<>();
        inlineKeyboardButton = new InlineKeyboardButton();
        inlineKeyboardButton.setText("Курица фри");
        inlineKeyboardButton.setUrl("https://core.telegram.org/bots/api#inlinekeyboardmarkup");
        inlineKeyboardButtons.add(inlineKeyboardButton);
        keyboard.add(inlineKeyboardButtons);
        inlineKeyboardButtons = new ArrayList<>();
        inlineKeyboardButton = new InlineKeyboardButton();
        inlineKeyboardButton.setText("Картофель фри и кукуруза");
        inlineKeyboardButton.setUrl("https://core.telegram.org/bots/api#inlinekeyboardmarkup");
        inlineKeyboardButtons.add(inlineKeyboardButton);
        keyboard.add(inlineKeyboardButtons);
        inlineKeyboardButtons = new ArrayList<>();
        inlineKeyboardButton = new InlineKeyboardButton();
        inlineKeyboardButton.setText("Салаты");
        inlineKeyboardButton.setUrl("https://core.telegram.org/bots/api#inlinekeyboardmarkup");
        inlineKeyboardButtons.add(inlineKeyboardButton);
        keyboard.add(inlineKeyboardButtons);
        inlineKeyboardButtons = new ArrayList<>();
        inlineKeyboardButton = new InlineKeyboardButton();
        inlineKeyboardButton.setText("Пироги");
        inlineKeyboardButton.setUrl("https://core.telegram.org/bots/api#inlinekeyboardmarkup");
        inlineKeyboardButtons.add(inlineKeyboardButton);
        keyboard.add(inlineKeyboardButtons);
        inlineKeyboardButtons = new ArrayList<>();
        inlineKeyboardButton = new InlineKeyboardButton();
        inlineKeyboardButton.setText("Десерты");
        inlineKeyboardButton.setUrl("https://core.telegram.org/bots/api#inlinekeyboardmarkup");
        inlineKeyboardButtons.add(inlineKeyboardButton);
        keyboard.add(inlineKeyboardButtons);
        inlineKeyboardButtons = new ArrayList<>();
        inlineKeyboardButton = new InlineKeyboardButton();
        inlineKeyboardButton.setText("Соусы");
        inlineKeyboardButton.setUrl("https://core.telegram.org/bots/api#inlinekeyboardmarkup");
        inlineKeyboardButtons.add(inlineKeyboardButton);
        keyboard.add(inlineKeyboardButtons);
        inlineKeyboardButtons = new ArrayList<>();
        inlineKeyboardButton = new InlineKeyboardButton();
        inlineKeyboardButton.setText("Напитки");
        inlineKeyboardButton.setUrl("https://core.telegram.org/bots/api#inlinekeyboardmarkup");
        inlineKeyboardButtons.add(inlineKeyboardButton);
        keyboard.add(inlineKeyboardButtons);
        inlineKeyboardMarkup.setKeyboard(keyboard);
        try {
            sendMessage(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

}

