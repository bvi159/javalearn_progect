package com.javarush.task.task30.task3008.client;

public class ClientGuiController extends Client {
    // 2. Поле для модели
    private ClientGuiModel model = new ClientGuiModel();

    // 3. Поле для представления
    private ClientGuiView view = new ClientGuiView(this);

    // 4. Внутренний класс GuiSocketThread
    public class GuiSocketThread extends SocketThread {
        @Override
        protected void processIncomingMessage(String message) {
            // Устанавливаем новое сообщение в модели и обновляем вывод
            model.setNewMessage(message);
            view.refreshMessages();
        }

        @Override
        protected void informAboutAddingNewUser(String userName) {
            // Добавляем пользователя в модель и обновляем вывод
            model.addUser(userName);
            view.refreshUsers();
        }

        @Override
        protected void informAboutDeletingNewUser(String userName) {
            // Удаляем пользователя из модели и обновляем вывод
            model.deleteUser(userName);
            view.refreshUsers();
        }

        @Override
        protected void notifyConnectionStatusChanged(boolean clientConnected) {
            // Вызываем аналогичный метод у представления
            view.notifyConnectionStatusChanged(clientConnected);
            // Также вызываем родительский метод для синхронизации
            super.notifyConnectionStatusChanged(clientConnected);
        }
    }

    // 5. Переопределенные методы

    @Override
    protected SocketThread getSocketThread() {
        // Создаем и возвращаем объект типа GuiSocketThread
        return new GuiSocketThread();
    }

    @Override
    public void run() {
        // Получаем объект SocketThread и вызываем у него метод run()
        SocketThread socketThread = getSocketThread();
        socketThread.run(); // В GUI не нужно в отдельном потоке, т.к. UI поток уже отдельный
    }

    @Override
    protected String getServerAddress() {
        // Вызываем одноименный метод из представления
        return view.getServerAddress();
    }

    @Override
    protected int getServerPort() {
        // Вызываем одноименный метод из представления
        return view.getServerPort();
    }

    @Override
    protected String getUserName() {
        // Вызываем одноименный метод из представления
        return view.getUserName();
    }

    @Override
    protected boolean shouldSendTextFromConsole() {
        // В GUI-клиенте не нужно отправлять текст из консоли
        return false;
    }

    // 6. Метод для получения модели
    public ClientGuiModel getModel() {
        return model;
    }

    // 7. Метод main()
    public static void main(String[] args) {
        // Создаем новый объект ClientGuiController и вызываем у него метод run()
        ClientGuiController controller = new ClientGuiController();
        controller.run();
    }
}