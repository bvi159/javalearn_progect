package ru.javarush.java.core.level09.task20;

/*
Удаление и замена
Вы — редактор текстов будущего, работающий над системой персонализации рекламных сообщений. Иногда требуется быстро отредактировать шаблонное сообщение: удалить лишние слова, чтобы оно стало более нейтральным, а затем заменить ключевое слово на более подходящее по контексту. Гибкость и точность — ваши инструменты.

Возьмите стартовую фразу "Я люблю Java!" в вашем StringBuilder. Ваша задача состоит из двух этапов: сначала удалите из неё слово "люблю" (помните о сохранении пробелов!), чтобы структура предложения не нарушалась. Затем замените слово "Java" на "программирование", чтобы фраза обрела новый смысл. В конце выведите получившуюся обновлённую фразу на экран, демонстрируя свои навыки "хирургии" текста.

Требования:
•	Решение должно использовать класс StringBuilder для всех операций редактирования строки.
•	Стартовая фраза "Я люблю Java!" должна быть передана в StringBuilder при его создании.
•	Необходимо удалить из строки слово "люблю", при этом сохранить пробелы так, чтобы структура предложения осталась корректной.
•	Слово "Java" в строке должно быть заменено на "программирование" с помощью методов StringBuilder.
•	Обновлённая фраза должна быть выведена на экран после всех изменений.
public class Solution {
    public static void main(String[] args) {
        // Инициализация стартовой фразы в StringBuilder


        // Удаление слова "люблю" с сохранением пробелов


        // Замена слова "Java" на "программирование"


        // Вывод обновленной фразы на экран

    }
}


 */
public class Solution {
    public static void main(String[] args) {
        // Инициализация стартовой фразы в StringBuilder
        StringBuilder advertismentText = new StringBuilder("Я люблю Java!");

        // Удаление слова "люблю" с сохранением пробелов
        int love = advertismentText.indexOf("люблю");
        int java = advertismentText.indexOf("Java");
        advertismentText.delete(love, java);


        // Замена слова "Java" на "программирование"
        java = advertismentText.indexOf("Java");
        advertismentText.replace(java, java + 4, "программирование");

        // Вывод обновленной фразы на экран
        System.out.println(advertismentText);
        System.out.println("\u263a");
        System.out.println("😊".length());

    }
}
/*
ихнее решение
public class Solution {
    public static void main(String[] args) {
        // Стартовая фраза сразу в StringBuilder
        StringBuilder sb = new StringBuilder("Я люблю Java!");

        // 1) Удаляем слово "люблю" вместе со следующим пробелом,
        // чтобы не осталось двойного пробела между "Я" и "Java!"
        int loveStart = sb.indexOf("люблю");
        sb.delete(loveStart, loveStart + "люблю ".length());

        // 2) Заменяем "Java" на "программирование"
        int javaStart = sb.indexOf("Java");
        sb.replace(javaStart, javaStart + "Java".length(), "программирование");

        // 3) Выводим обновлённую фразу
        System.out.println(sb);
    }
}

 */