package com.javarush.task.task30.task3008;

import java.io.Closeable;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketAddress;

public class Connection implements Closeable {
    private final Socket socket;
    private final ObjectOutputStream out;
    private final ObjectInputStream in;
//    private final Object writeLock = new Object(); // Объект для синхронизации

    public Connection(Socket socket) throws IOException {
        this.socket = socket;

        // Важно создавать потоки в правильном порядке!
        // Сначала ObjectOutputStream, потом ObjectInputStream
        this.out = new ObjectOutputStream(socket.getOutputStream());
        this.in = new ObjectInputStream(socket.getInputStream());
    }

    public void send(Message message) throws IOException {
        synchronized (out) {
            out.writeObject(message);
            out.flush();
        }

    }




    public Message receive() throws IOException, ClassNotFoundException {
        synchronized (in) { // synchronized блок по объекту in
            return (Message) in.readObject();
        }
    }

    public SocketAddress getRemoteSocketAddress() {
        return socket.getRemoteSocketAddress();
    }

    public void close() throws IOException {
        // Закрываем потоки
        out.close();
        in.close();
        socket.close();
    }
}
