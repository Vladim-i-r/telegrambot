package es.codegym.telegrambot;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.util.Map;

import static es.codegym.telegrambot.TelegramBotContent.*;

public class MyFirstTelegramBot extends MultiSessionTelegramBot {

    public static final String NAME = "CodeVBot_bot";
    public static final String TOKEN = "6711458685:AAEea3hSJMa8gEVQQufGsV2i0ej5BB2QRWg";

    public MyFirstTelegramBot() {
        super(NAME, TOKEN);
    }

    @Override
    public void onUpdateEventReceived(Update update) {
        // TODO: escribiremos la funcionalidad principal del bot aquí
        if (getMessageText().equals("/start")){
            setUserGlory(0);
            sendPhotoMessageAsync("step_1_pic");
            sendTextMessageAsync(STEP_1_TEXT,
            Map.of("Hackear la nevera","step_1_btn"));

        }

        if (getCallbackQueryButtonKey().equals("step_0_btn")){
            setUserGlory(0);
            sendPhotoMessageAsync("step_1_pic");
            sendTextMessageAsync(STEP_0_TEXT,
                    Map.of("Hackear nuevamente la nevera","step_1_btn"));

        }

        if (getCallbackQueryButtonKey().equals("step_1_btn")){
            setUserGlory(20);
            sendPhotoMessageAsync("step_2_pic");
            sendTextMessageAsync(STEP_2_TEXT,
                    Map.of("Tomar una salchicha! +20 de fama","step_2_btn",
                    "Tomar un pescado! +20 de fama","step_0_btn",
                    "Tirar una lata de pepinillos! +20 de fama","step_2_btn"));
        }

        if (getCallbackQueryButtonKey().equals("step_2_btn")){
            setUserGlory(20);
            sendPhotoMessageAsync("step_3_pic");
            sendTextMessageAsync(STEP_3_TEXT,
                    Map.of("Hackear al robot aspirador","step_3_btn"));
        }

        if (getCallbackQueryButtonKey().equals("step_3_btn")){
            setUserGlory(30);
            sendPhotoMessageAsync("step_4_pic");
            sendTextMessageAsync(STEP_4_TEXT,
                    Map.of("Enviar al robot por algo de comer! +30 de fama","step_4_btn",
                            "Dar un pase en el robot aspirador! +30 de fama","step_4_btn",
                            "¡Huir del robot aspirador! +30 de fama","step_4_btn"));
        }

        if (getCallbackQueryButtonKey().equals("step_4_btn")){
            setUserGlory(30);
            sendPhotoMessageAsync("step_5_pic");
            sendTextMessageAsync(STEP_5_TEXT,
                    Map.of("Poner GoPro y encenderla! +40 de fama","step_5_btn"));
        }

        if (getCallbackQueryButtonKey().equals("step_5_btn")){
            setUserGlory(40);
            sendPhotoMessageAsync("step_6_pic");
            sendTextMessageAsync(STEP_6_TEXT,
                    Map.of("Te quedas la GoPro de recuerdo! +40 de fama","step_6_btn",
                            "Tomas dos latas de atun! +40 de fama","step_6_btn",
                            "Jugar con un peluche con campana! +40 de fama","step_6_btn"));
        }

        if (getCallbackQueryButtonKey().equals("step_6_btn")){
            setUserGlory(40);
            sendPhotoMessageAsync("step_7_pic");
            sendTextMessageAsync(STEP_7_TEXT,
                    Map.of("Hackear la contraseña! +50 de fama","step_7_btn"));
        }

        if (getCallbackQueryButtonKey().equals("step_7_btn")){
            setUserGlory(50);
            sendPhotoMessageAsync("step_8_pic");
            sendTextMessageAsync(STEP_8_TEXT,
                    Map.of("Concluir el hackeo","step_8_btn"));
        }

        if (getCallbackQueryButtonKey().equals("step_8_btn")){
            addUserGlory(230);
            sendPhotoMessageAsync("final_pic");
            sendTextMessageAsync(FINAL_TEXT);
        }
        /* if (getMessageText().contains("hola")){
            sendTextMessageAsync("Hola, cuál es tu nombre completo?");
        }
        if (getMessageText().contains("Me llamo")){
            String a = getMessageText().replace("Me llamo","");
            sendTextMessageAsync("Encantado de cononcerte" + "_" + a + "_" + ", yo soy *Gato*.");
        }*/
    }
    public static void main(String[] args) throws TelegramApiException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(new MyFirstTelegramBot());
    }
}