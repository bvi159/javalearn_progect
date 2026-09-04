package com.javarush.task.task25.task2507;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/* 
Работать в поте лица!

Реализуй логику метода interrupt, который должен прерывать трэд предварительно закрыв используемые ресурсы.
Используй метод super-класса в блоке finally.

Требования:
•	Сигнатуру метода interrupt менять нельзя.
•	Метод interrupt должен закрывать используемые классом Solution ресурсы.
•	Затем, метод interrupt должен прерывать трэд (вызов super.interrupt).
•	Трэд должен быть прерван в любом случае, даже если во время закрытия ресурсов было выкинуто исключение.

public class Solution extends Thread {
    private static final int BUFFER_SIZE = 2000;    //2000 bytes
    private final Socket socket;
    private final InputStream in;

    public Solution(Socket socket) throws IOException {
        this.socket = socket;
        this.in = socket.getInputStream();
    }

    @Override
    public void interrupt() {
        try {
            socket.close();
        } catch (IOException ignored) {
        } finally {
            super.interrupt();
        }
    }

    public void run() {
        try {
            byte[] buf = new byte[BUFFER_SIZE];
            while (true) {
                int count = in.read(buf);
                if (count < 0) {
                    break;
                } else {
                    if (count > 0) {
                        //process buffer here
                    }
                }
            }
        } catch (IOException ignored) {
        }
    }

    public static void main(String[] args) {
    }
}

*/

public class Solution extends Thread {
    private static final int BUFFER_SIZE = 2000;    //2000 bytes
    private final Socket socket;
    private final InputStream in;

    public Solution(Socket socket) throws IOException {
        this.socket = socket;
        this.in = socket.getInputStream();
    }

    public void interrupt() {
        //implement logic here
        try {
            // Закрываем используемые ресурсы
            if (in != null) {
                in.close();
            }
            if (socket != null) {
                socket.close();
            }
        } catch (IOException ignored) {
            // Игнорируем исключения при закрытии ресурсов
        } finally {
            // В любом случае прерываем трэд
            // Здесь прерывается ТЕКУЩИЙ объект Solution (который является Thread)
            super.interrupt();
            System.out.println("Поток " + this.getName() + " прерван");
        }

    }

    public void run() {
        try {
            byte[] buf = new byte[BUFFER_SIZE];
            while (true) {
                int count = in.read(buf);
                if (count < 0) {
                    break;
                } else {
                    if (count > 0) {
                        //process buffer here
                        System.out.println("Обработано " + count + " байт");//process buffer here
                    }
                }
            }
        } catch (IOException ignored) {
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        // Создаем серверный сокет для демонстрации
        ServerSocket serverSocket = new ServerSocket(8080);

        // Имитируем подключение клиента (в реальном коде это был бы удаленный клиент)
        Socket clientSocket = new Socket("localhost", 8080);
        Socket serverSideSocket = serverSocket.accept();

        // Создаем объект Solution (который является потоком)
        Solution solutionThread = new Solution(clientSocket);

        System.out.println("Создан поток: " + solutionThread.getName());
        System.out.println("ID потока: " + solutionThread.getId());
        System.out.println("Объект: " + solutionThread);

        // Запускаем поток
        solutionThread.start();

        // Даем потоку поработать немного
        Thread.sleep(100);

        // Прерываем поток - вызовется наш метод interrupt()
        System.out.println("Прерываем поток...");
        solutionThread.interrupt(); // Вызовет наш переопределенный метод

        // Ждем завершения потока
        solutionThread.join();

        // Закрываем ресурсы
        serverSideSocket.close();
        serverSocket.close();

        System.out.println("Main завершен");
    }
}
/* Исходник
public class Solution extends Thread {
    private static final int BUFFER_SIZE = 2000;    //2000 bytes
    private final Socket socket;
    private final InputStream in;

    public Solution(Socket socket) throws IOException {
        this.socket = socket;
        this.in = socket.getInputStream();
    }

    public void interrupt() {
        //implement logic here
    }

    public void run() {
        try {
            byte[] buf = new byte[BUFFER_SIZE];
            while (true) {
                int count = in.read(buf);
                if (count < 0) {
                    break;
                } else {
                    if (count > 0) {
                        //process buffer here
                    }
                }
            }
        } catch (IOException ignored) {
        }
    }

    public static void main(String[] args) {
    }
}
 */