package ru.javarush.java.core.level43.task02;
/*
Профиль Игрока: Сохранение Сути, Забвение Деталей
Вы разрабатываете захватывающую многопользовательскую игру "Эпические Путешествия", и вам необходимо надежно сохранять прогресс игроков.

Создайте класс Profile, который будет представлять игровой профиль и содержать playerUsername (имя игрока), playerEmail (его электронную почту) и playerScore (набранные очки).

Чтобы профили игроков можно было сохранять и загружать, класс Profile должен реализовать Serializable.

Однако, по строгим правилам конфиденциальности, электронная почта игрока не должна сохраняться на диске вместе с остальными данными профиля, она нужна только во время активной игровой сессии.

Вам потребуется реализовать кастомные методы writeObject и readObject. При сериализации (в writeObject) сохраняйте только playerUsername и playerScore, игнорируя playerEmail.

В обоих методах добавьте логирование: "Сохраняем профиль пользователя: [имя]" при сериализации и "Восстанавливаем профиль пользователя: [имя]" при десериализации.

Ваша цель — убедиться, что после того, как вы создадите профиль, заполните все его поля, сохраните и затем восстановите, поле playerEmail будет магическим образом null, в то время как playerUsername и playerScore останутся нетронутыми и верными.

Выведите все поля восстановленного профиля на экран, чтобы подтвердить, что всё работает как задумано.

Требования:
•	Класс Profile должен реализовывать интерфейс Serializable для поддержки сериализации.
•	Класс Profile должен содержать три поля: playerUsername (имя игрока), playerEmail (электронная почта), playerScore (очки игрока).
•	В методе writeObject(ObjectOutputStream out) должны сериализоваться только поля playerUsername и playerScore. Поле playerEmail не должно сохраняться.
•	В методе readObject(ObjectInputStream in) должны корректно восстанавливаться только поля playerUsername и playerScore. Поле playerEmail после десериализации должно быть равно null.
•	В методе writeObject должно выводиться сообщение "Сохраняем профиль пользователя: [имя]", где [имя] — значение поля playerUsername.
•	В методе readObject должно выводиться сообщение "Восстанавливаем профиль пользователя: [имя]", где [имя] — восстановленное значение поля playerUsername.
•	После десериализации необходимо вывести значения всех трех полей профиля на экран, чтобы убедиться, что playerUsername и playerScore восстановлены, а playerEmail равен null.

import java.io.*;

// Точка входа: создаем профиль, сериализуем его, затем читаем обратно и проверяем поля
public class Solution {
    public static void main(String[] args) throws Exception {
        // Создаем профиль и заполняем все поля
        Profile original = new Profile("Hero123", "hero@example.com", 9001);

        // Сохраняем объект в бинарный файл
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("profile.bin"))) {
            out.writeObject(original);
        }

        // Восстанавливаем объект из файла
        Profile restored;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("profile.bin"))) {
            restored = (Profile) in.readObject();
        }

        // Выводим все поля восстановленного профиля
        System.out.println("После десериализации:");
        System.out.println("playerUsername = " + restored.getPlayerUsername());
        System.out.println("playerEmail = " + restored.getPlayerEmail()); // должен быть null
        System.out.println("playerScore = " + restored.getPlayerScore());
    }
}

 */

import java.io.*;

// Точка входа: создаем профиль, сериализуем его, затем читаем обратно и проверяем поля
public class Solution {
    public static void main(String[] args) throws Exception {
        // Создаем профиль и заполняем все поля
        Profile original = new Profile("Hero123", "hero@example.com", 9001);

        // Сохраняем объект в бинарный файл
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("profile.bin"))) {
            out.writeObject(original);
        }

        // Восстанавливаем объект из файла
        Profile restored;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("profile.bin"))) {
            restored = (Profile) in.readObject();
        }

        // Выводим все поля восстановленного профиля
        System.out.println("После десериализации:");
        System.out.println("playerUsername = " + restored.getPlayerUsername());
        System.out.println("playerEmail = " + restored.getPlayerEmail()); // должен быть null
        System.out.println("playerScore = " + restored.getPlayerScore());
    }
}

class Profile implements Serializable {
    private String playerUsername;
    transient private String playerEmail;
    private int playerScore;

    public Profile(String user, String email, int score) {
        this.playerUsername = user;
        this.playerEmail = email;
        this.playerScore = score;
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        System.out.println("Сохраняем профиль пользователя: " + playerUsername);
        out.defaultWriteObject();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        System.out.println("Восстанавливаем профиль пользователя: " + playerUsername);
    }

    public String getPlayerUsername() {
        return playerUsername;
    }

    public String getPlayerEmail() {
        return playerEmail;
    }

    public int getPlayerScore() {
        return playerScore;
    }

}

/*
import java.io.*;

// Точка входа: создаем профиль, сериализуем его, затем читаем обратно и проверяем поля
public class Solution {
    public static void main(String[] args) throws Exception {
        // Создаем профиль и заполняем все поля
        Profile original = new Profile("Hero123", "hero@example.com", 9001);

        // Сохраняем объект в бинарный файл
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("profile.bin"))) {
            out.writeObject(original);
        }

        // Восстанавливаем объект из файла
        Profile restored;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("profile.bin"))) {
            restored = (Profile) in.readObject();
        }

        // Выводим все поля восстановленного профиля
        System.out.println("После десериализации:");
        System.out.println("playerUsername = " + restored.getPlayerUsername());
        System.out.println("playerEmail = " + restored.getPlayerEmail()); // должен быть null
        System.out.println("playerScore = " + restored.getPlayerScore());
    }
}

// Класс профиля с кастомной сериализацией: сохраняем только имя и очки, email игнорируем
class Profile implements Serializable {
    private static final long serialVersionUID = 1L;

    private String playerUsername;
    private String playerEmail;
    private int playerScore;

    public Profile(String playerUsername, String playerEmail, int playerScore) {
        this.playerUsername = playerUsername;
        this.playerEmail = playerEmail;
        this.playerScore = playerScore;
    }

    // Кастомная сериализация: сохраняем только имя и очки (email не пишем)
    private void writeObject(ObjectOutputStream out) throws IOException {
        // Логирование по условию задачи
        System.out.println("Сохраняем профиль пользователя: " + playerUsername);

        // Записываем только необходимые поля
        out.writeObject(playerUsername);
        out.writeInt(playerScore);
    }

    // Кастомная десериализация: восстанавливаем только имя и очки, email оставляем null
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        // Читаем в том же порядке, в котором писали
        this.playerUsername = (String) in.readObject();
        this.playerScore = in.readInt();

        // Email сознательно не восстанавливаем
        this.playerEmail = null;

        // Логирование по условию задачи — используем уже восстановленное имя
        System.out.println("Восстанавливаем профиль пользователя: " + playerUsername);
    }

    // Геттеры для удобного вывода
    public String getPlayerUsername() {
        return playerUsername;
    }

    public String getPlayerEmail() {
        return playerEmail;
    }

    public int getPlayerScore() {
        return playerScore;
    }
}
 */