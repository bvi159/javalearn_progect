package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.Connection;
import com.javarush.task.task30.task3008.ConsoleHelper;
import com.javarush.task.task30.task3008.Message;
import com.javarush.task.task30.task3008.MessageType;

import java.io.IOException;
import java.net.Socket;


public class Client {
    protected Connection connection;
    private volatile boolean clientConnected = false;

    // Остальные методы класса Client остаются без изменений
    protected String getServerAddress() {
        System.out.print("Введите адрес сервера (localhost или IP): ");
        return ConsoleHelper.readString();
    }

    protected int getServerPort() {
        System.out.print("Введите порт сервера: ");
        return ConsoleHelper.readInt();
    }

    protected String getUserName() {
        System.out.print("Введите ваше имя: ");
        return ConsoleHelper.readString();
    }


    public class SocketThread extends Thread {
        @Override
        public void run() {
            try {
                // Получаем адрес и порт
                String serverAddress = getServerAddress();
                int serverPort = getServerPort();

                // Устанавливаем соединение
                Socket socket = new Socket(serverAddress, serverPort);
                connection = new Connection(socket);

                // Выполняем рукопожатие
                clientHandshake();

                // Запускаем главный цикл обработки сообщений
                clientMainLoop();

            } catch (IOException | ClassNotFoundException e) {
                // При любой ошибке уведомляем о разрыве соединения
                notifyConnectionStatusChanged(false);
            }
        }

        /**
         * Представляет клиента серверу (рукопожатие)
         */
        protected void clientHandshake() throws IOException, ClassNotFoundException {
            while (true) {
                // а) В цикле получаем сообщения, используя соединение connection
                Message message = connection.receive();

                // б) Если сервер запросил имя
                if (message.getType() == MessageType.NAME_REQUEST) {
                    // Запрашиваем ввод имени пользователя
                    String userName = getUserName();

                    // Создаем новое сообщение с типом USER_NAME и введенным именем
                    Message response = new Message(MessageType.USER_NAME, userName);

                    // Отправляем сообщение серверу
                    connection.send(response);
                }
                // в) Если сервер принял имя клиента
                else if (message.getType() == MessageType.NAME_ACCEPTED) {
                    // Сообщаем главному потоку, что соединение установлено
                    notifyConnectionStatusChanged(true);

                    // Выходим из метода
                    return;
                }
                // г) Если пришло сообщение с каким-либо другим типом
                else {
                    throw new IOException("Unexpected MessageType");
                }
            }
        }

        /**
         * Главный цикл обработки сообщений сервера
         */
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            // е) Бесконечный цикл обработки сообщений
            while (true) {
                // а) Получаем сообщение от сервера
                Message message = connection.receive();

                // б) Если это текстовое сообщение
                if (message.getType() == MessageType.TEXT) {
                    // Обрабатываем его
                    processIncomingMessage(message.getData());
                }
                // в) Если это сообщение о добавлении пользователя
                else if (message.getType() == MessageType.USER_ADDED) {
                    // Обрабатываем добавление пользователя
                    informAboutAddingNewUser(message.getData());
                }
                // г) Если это сообщение об удалении пользователя
                else if (message.getType() == MessageType.USER_REMOVED) {
                    // Обрабатываем удаление пользователя
                    informAboutDeletingNewUser(message.getData());
                }
                // д) Если клиент получил сообщение какого-либо другого типа
                else {
                    throw new IOException("Unexpected MessageType");
                }
            }
        }

        // Остальные методы SocketThread
        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);
        }

        protected void informAboutAddingNewUser(String userName) {
            ConsoleHelper.writeMessage("Участник '" + userName + "' присоединился к чату.");
        }

        protected void informAboutDeletingNewUser(String userName) {
            ConsoleHelper.writeMessage("Участник '" + userName + "' покинул чат.");
        }

        protected void notifyConnectionStatusChanged(boolean clientConnected) {
            Client.this.clientConnected = clientConnected;
            synchronized (Client.this) {
                Client.this.notify();
            }
        }
    }

    protected SocketThread getSocketThread() {
        return new SocketThread();
    }

    protected void sendTextMessage(String text) {
        try {
            if (connection != null) {
                Message message = new Message(MessageType.TEXT, text);
                connection.send(message);
            } else {
                ConsoleHelper.writeMessage("Ошибка: соединение с сервером не установлено.");
                clientConnected = false;
            }
        } catch (IOException e) {
            ConsoleHelper.writeMessage("Произошла ошибка при отправке сообщения: " + e.getMessage());
            clientConnected = false;
        }
    }
    protected boolean shouldSendTextFromConsole() {
        return true;
    }

    public void run() {
        SocketThread socketThread = getSocketThread();
        socketThread.setDaemon(true);
        socketThread.start();

        try {
            synchronized (this) {
                wait();
            }
        } catch (InterruptedException e) {
            ConsoleHelper.writeMessage("Ошибка ожидания соединения: " + e.getMessage());
            return;
        }

        if (clientConnected) {
            ConsoleHelper.writeMessage("Соединение установлено. Для выхода наберите команду 'exit'.");

            while (clientConnected) {
                String message = ConsoleHelper.readString();

                if ("exit".equalsIgnoreCase(message.trim())) {
                    break;
                }

                if (shouldSendTextFromConsole()) {
                    sendTextMessage(message);
                }
            }
        } else {
            ConsoleHelper.writeMessage("Произошла ошибка во время работы клиента.");
        }
    }


    /**
     * Точка входа в программу
     */
    public static void main(String[] args) {
        Client client = new Client();
        client.run();
    }

}
/*
//        @Override
//        public void run() {
//            try {
//                // Создаем соединение с сервером
//                connection = new Connection(new Socket(getServerAddress(), getServerPort()));
//
//                clientHandshake();
//                clientMainLoop();
//
//            } catch (IOException | ClassNotFoundException e) {
//                notifyConnectionStatusChanged(false);
//            }
//        }


 public boolean isClientConnected() {
        return clientConnected;
    }

    public void setClientConnected(boolean clientConnected) {
        this.clientConnected = clientConnected;
    }



 */