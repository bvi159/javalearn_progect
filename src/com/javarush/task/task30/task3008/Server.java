package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class Server {
    // Используем ConcurrentHashMap для потокобезопасности
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    // Вспомогательный метод для безопасной рассылки сообщений всем пользователям
    public static void sendBroadcastMessage(Message message) {
        for (Connection connection : connectionMap.values()) {
            try {
                connection.send(message);
            } catch (Exception e) {
                ConsoleHelper.writeMessage("Не удалось отправить сообщение пользователю");
            }
        }
    }

    private static class Handler extends Thread {
        private Socket socket;

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {
            while (true) {
                // 1) Сформировать и отправить команду запроса имени пользователя
                connection.send(new Message(MessageType.NAME_REQUEST));

                // 2) Получить ответ клиента
                Message response = connection.receive();

                // 3) Проверить, что получена команда с именем пользователя
                if (response.getType() != MessageType.USER_NAME) {
                    ConsoleHelper.writeMessage("Получено сообщение неверного типа от " +
                            socket.getRemoteSocketAddress() + ". Ожидается " +
                            MessageType.USER_NAME + ", а получено " + response.getType());
                    continue;
                }

                // 4) Достать из ответа имя
                String userName = response.getData();

                // Проверить, что оно не пустое
                if (userName == null || userName.trim().isEmpty()) {
                    ConsoleHelper.writeMessage("Попытка подключения к серверу с пустым именем от " +
                            socket.getRemoteSocketAddress());
                    continue;
                }

                // Проверить, что пользователь с таким именем еще не подключен
                if (connectionMap.containsKey(userName)) {
                    ConsoleHelper.writeMessage("Попытка подключения к серверу с уже используемым именем '" +
                            userName + "' от " + socket.getRemoteSocketAddress());
                    continue;
                }

                // 5) Добавить нового пользователя и соединение с ним в connectionMap
                connectionMap.put(userName, connection);

                // 6) Отправить клиенту команду информирующую, что его имя принято
                connection.send(new Message(MessageType.NAME_ACCEPTED));

                // 7) Если все проверки прошли успешно, вернуть имя
                ConsoleHelper.writeMessage("Имя пользователя '" + userName + "' принято");
                return userName;

                // 8) Если какая-то проверка не прошла, цикл while(true) заново запросит имя
            }
        }

        /**
         * Уведомляет пользователя о всех других участниках чата
         *
         * @param connection соединение с участником, которому отправляем информацию
         * @param userName   имя участника
         * @throws IOException если произошла ошибка при отправке
         */
        private void notifyUsers(Connection connection, String userName) throws IOException {
            // 1) Проходимся по connectionMap
            for (Map.Entry<String, Connection> entry : connectionMap.entrySet()) {
                String currentUserName = entry.getKey();

                // 4) Пропускаем самого пользователя
                if (currentUserName.equals(userName)) {
                    continue;
                }

                // 2) Формируем команду с типом USER_ADDED и полученным именем
                Message userAddedMessage = new Message(MessageType.USER_ADDED, currentUserName);

                // 3) Отправляем сформированную команду через connection
                try {
                    connection.send(userAddedMessage);
                    ConsoleHelper.writeMessage("Отправлено уведомление о пользователе '" +
                            currentUserName + "' пользователю '" + userName + "'");
                } catch (IOException e) {
                    ConsoleHelper.writeMessage("Не удалось отправить уведомление о пользователе '" +
                            currentUserName + "' пользователю '" + userName + "'");
                    throw e; // Пробрасываем исключение дальше
                }
            }
        }

        /**
         * Основной цикл обработки сообщений от клиента
         *
         * @param connection соединение с клиентом
         * @param userName   имя клиента
         * @throws IOException            если произошла ошибка ввода-вывода
         * @throws ClassNotFoundException если возникла проблема с десериализацией
         */
        private void serverMainLoop(Connection connection, String userName)
                throws IOException, ClassNotFoundException {
            // 5. Организуем бесконечный цикл
            while (true) {
                // 1. Принимаем сообщение клиента
                Message clientMessage = connection.receive();

                // 2. Проверяем, что принятое сообщение - это текст (тип TEXT)
                if (clientMessage.getType() == MessageType.TEXT) {
                    // Формируем новое текстовое сообщение путем конкатенации:
                    // имени клиента, двоеточия, пробела и текста сообщения
                    String formattedMessage = userName + ": " + clientMessage.getData();

                    // Создаем новое сообщение с отформатированным текстом
                    Message broadcastMessage = new Message(MessageType.TEXT, formattedMessage);

                    // 3. Отправляем сформированное сообщение всем клиентам
                    sendBroadcastMessage(broadcastMessage);

                    // Для отладки выводим в консоль сервера
                    ConsoleHelper.writeMessage("Сообщение от '" + userName + "': " + clientMessage.getData());
                } else {
                    // 4. Если принятое сообщение не является текстом, выводим сообщение об ошибке
                    ConsoleHelper.writeMessage("Ошибка: получено сообщение неверного типа от пользователя '" +
                            userName + "'. Ожидается TEXT, получено: " + clientMessage.getType());

                    // Можно также отправить сообщение об ошибке клиенту
                    // connection.send(new Message(MessageType.ERROR, "Поддерживаются только текстовые сообщения"));
                }

                // Цикл продолжается бесконечно, пока не произойдет исключение
                // (например, разрыв соединения)
            }
        }


        public Handler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // 1. Выводим сообщение, что установлено новое соединение
            ConsoleHelper.writeMessage("Установлено новое соединение с удаленным адресом: " +
                    socket.getRemoteSocketAddress());

            String userName = null;

            try {
                // 2. Создаем Connection, используя поле socket
                Connection connection = new Connection(socket);

                // 3. Вызываем метод, реализующий рукопожатие с клиентом
                userName = serverHandshake(connection);

                // 4. Рассылаем всем участникам чата информацию об имени присоединившегося участника
                Message userAddedMessage = new Message(MessageType.USER_ADDED, userName);
                sendBroadcastMessage(userAddedMessage);

                // 5. Сообщаем новому участнику о существующих участниках
                notifyUsers(connection, userName);

                // Информируем о успешном подключении
                ConsoleHelper.writeMessage("Пользователь '" + userName + "' успешно подключился к чату. " +
                        "Участников в чате: " + connectionMap.size());

                // 6. Запускаем главный цикл обработки сообщений сервером
                serverMainLoop(connection, userName);

            } catch (IOException | ClassNotFoundException e) {
                // 8. Отлавливаем все исключения типа IOException и ClassNotFoundException
                ConsoleHelper.writeMessage("Произошла ошибка при обмене данными с удаленным адресом: " +
                        socket.getRemoteSocketAddress() + ". " + e.getMessage());
            } finally {
                // 7. Обеспечиваем закрытие соединения при возникновении исключения
                if (socket != null && !socket.isClosed()) {
                    try {
                        socket.close();
                    } catch (IOException e) {
                        // Игнорируем ошибку закрытия сокета
                    }
                }

                // 9. Если рукопожатие отработало и возвратило нам имя
                if (userName != null && connectionMap.containsKey(userName)) {
                    // Удаляем запись для этого имени из connectionMap
                    connectionMap.remove(userName);

                    // Разослать всем остальным участникам сообщение с типом USER_REMOVED
                    Message userRemovedMessage = new Message(MessageType.USER_REMOVED, userName);
                    sendBroadcastMessage(userRemovedMessage);

                    ConsoleHelper.writeMessage("Пользователь '" + userName + "' был удален из чата");
                }

                // 10. Выводим сообщение, что соединение с удаленным адресом закрыто
                ConsoleHelper.writeMessage("Соединение с удаленным адресом " +
                        socket.getRemoteSocketAddress() + " закрыто.");
            }
        }


    }

    public static void main(String[] args) {
        ConsoleHelper.writeMessage("Введите порт сервера:");
        int port = ConsoleHelper.readInt();

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            ConsoleHelper.writeMessage("Чат сервер запущен.");
            while (true) {
                // Ожидаем входящее соединение и запускаем отдельный поток при его принятии
                Socket socket = serverSocket.accept();
                new Handler(socket).start();
            }
        } catch (Exception e) {
            ConsoleHelper.writeMessage("Произошла ошибка при запуске или работе сервера.");
        }
    }
}