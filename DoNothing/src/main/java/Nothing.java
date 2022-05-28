import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.File;
import java.time.Instant;


public class Nothing extends TelegramLongPollingBot {

    public String getBotUsername() {
        return TokenReader.readUserName();
    }

    public String getBotToken() {
        return TokenReader.readToken();
    }

    public void onUpdateReceived(Update update) {
        if(update.hasMessage() && update.getMessage().hasText()) {
            System.out.println(update.getMessage().getText() + " del grupo: " + update.getMessage().getChat().getTitle()+" idioma "+update.getMessage().getFrom().getLanguageCode());
            SQLIte.saveRegister(SQLIte.connection, update.getMessage().getFrom().getId().toString(), update.getMessage().getFrom().getFirstName(),
                    update.getMessage().getFrom().getLastName(), update.getMessage().getFrom().getUserName(), update.getMessage().getText(),
                    update.getMessage().getChatId().toString(), Instant.ofEpochSecond(update.getMessage().getDate()).toString(), update.getMessage().getChat().getTitle());
            if (update.getMessage().isCommand() && update.getMessage().isUserMessage()) {
                SendPhoto sendPhoto = new SendPhoto();
                if(update.getMessage().getFrom().getLanguageCode().equals("es")){
                    File file = new File("Donothingbot_es.png");
                    InputFile inputFile = new InputFile(file);
                    sendPhoto.setChatId(update.getMessage().getChatId().toString());
                    sendPhoto.setPhoto(inputFile);
                }else{
                    File file = new File("Donothingbot_en.png");
                    InputFile inputFile = new InputFile(file);
                    sendPhoto.setChatId(update.getMessage().getChatId().toString());
                    sendPhoto.setPhoto(inputFile);
                }
                try {
                    execute(sendPhoto);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

}
