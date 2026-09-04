package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.ConsoleHelper;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

public class BotClient extends Client {
    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }

    @Override
    protected boolean shouldSendTextFromConsole() {
        return false;
    }

    @Override
    protected String getUserName() {
        // Генерация имени бота в формате: date_bot_X, где X от 0 до 99
        int randomNumber = (int) (Math.random() * 100);
        return "date_bot_" + randomNumber;
    }

    public static void main(String[] args) {
        BotClient botClient = new BotClient();
        botClient.run();
    }

    public class BotSocketThread extends SocketThread {

//        // Форматтер для даты в формате d.MM.YYYY
//        private final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("d.MM.YYYY");
//        // Форматтер для времени
//        private final DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");


        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            // а) Отправляем приветственное сообщение
            sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");

            // б) Вызываем реализацию родительского класса
            super.clientMainLoop();
        }

        @Override
        protected void processIncomingMessage(String message) {
            // а) Выводим сообщение в консоль
            ConsoleHelper.writeMessage(message);

            // Проверяем, что сообщение содержит ": " и не является системным
            if (message != null && message.contains(": ")) {
                String[] parts = message.split(": ", 2);
                if (parts.length == 2) {
                    String senderName = parts[0];
                    String text = parts[1].trim();

                    // Получаем текущую дату и время
                    Calendar calendar = Calendar.getInstance();

                    // Определяем формат в зависимости от команды
                    SimpleDateFormat formatter = null;
                    String commandResult = "";

                    switch (text.toLowerCase()) {
                        case "дата":
                            formatter = new SimpleDateFormat("d.MM.yyyy");
                            commandResult = formatter.format(calendar.getTime());
                            break;
                        case "день":
                            formatter = new SimpleDateFormat("d");
                            commandResult = formatter.format(calendar.getTime());
                            break;
                        case "месяц":
                            formatter = new SimpleDateFormat("MMMM");
                            commandResult = formatter.format(calendar.getTime());
                            break;
                        case "год":
                            formatter = new SimpleDateFormat("yyyy");
                            commandResult = formatter.format(calendar.getTime());
                            break;
                        case "время":
                            formatter = new SimpleDateFormat("H:mm:ss");
                            commandResult = formatter.format(calendar.getTime());
                            break;
                        case "час":
                            formatter = new SimpleDateFormat("H");
                            commandResult = formatter.format(calendar.getTime());
                            break;
                        case "минуты":
                            formatter = new SimpleDateFormat("m");
                            commandResult = formatter.format(calendar.getTime());
                            break;
                        case "секунды":
                            formatter = new SimpleDateFormat("s");
                            commandResult = formatter.format(calendar.getTime());
                            break;
                        default:
                            // Если команда не распознана - не отвечаем
                            return;
                    }

                    // Формируем и отправляем ответ
                    String response = "Информация для " + senderName + ": " + commandResult;
                    sendTextMessage(response);
                }
            }
        }

        @Override
        protected void informAboutAddingNewUser(String userName) {
            ConsoleHelper.writeMessage("Участник '" + userName + "' присоединился к чату.");
        }

        @Override
        protected void informAboutDeletingNewUser(String userName) {
            ConsoleHelper.writeMessage("Участник '" + userName + "' покинул чат.");
        }
    }
}

//        @Override
//        protected void informAboutAddingNewUser(String userName) {
//            ConsoleHelper.writeMessage("Участник '" + userName + "' присоединился к чату.");
//        }
//
//        @Override
//        protected void informAboutDeletingNewUser(String userName) {
//            ConsoleHelper.writeMessage("Участник '" + userName + "' покинул чат.");
//        }
//
//    }
//}
