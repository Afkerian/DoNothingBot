import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class Main {
    public static void main(String[] args) {
        System.out.println("Load Bot");
        SQLIte.connection= SQLIte.connect();
        try {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(new Nothing());
            System.out.println("Hello, World!");

        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
