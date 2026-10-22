package ru.javarush.java.core.level46.task10;
/*
Страж входа в онлайн-клуб: проверка email 🚫
Представьте, что вы — суровый страж на входе в эксклюзивный онлайн-клуб. Каждый, кто пытается зарегистрироваться, должен предоставить абсолютно корректный адрес электронной почты, иначе вход закрыт! Ваша задача — настроить систему валидации, чтобы ни один некорректный email не проскочил.

Сначала создайте "правила допуска" — файл club-member-schema.json. В нём должно быть прописано, что обязательное поле "email" должно быть строкой и строго соответствовать формату электронной почты.

Содержание файла club-member-schema.json:

{
  "type": "object",
  "properties": {
    "email": { "type": "string", "format": "email" }
  },
  "required": ["email"]
}
Затем имитируйте попытку регистрации нарушителя, создав файл bad-member-data.json с некорректным адресом электронной почты:

{
  "email": "not-an-email"
}
Теперь самое главное: напишите программу на Java, которая использует библиотеку everit-org/json-schema. Ваша программа должна загрузить и правила допуска, и данные нарушителя из файлов, а затем провести строгую валидацию. Если данные не проходят проверку (а в нашем случае они не пройдут, так как email невалидный), программа должна чётко и ясно сообщить на экране об ошибке формата email, чтобы вы знали, кого не пускать в клуб!

Требования:
•	В папке проекта должен быть создан файл club-member-schema.json с содержимым, соответствующим JSON-схеме, требующей обязательное строковое поле email с форматом email.
•	В папке проекта должен быть создан файл bad-member-data.json, содержащий объект с полем email, установленным в значение "not-an-email".
•	Программа должна использовать библиотеку everit-org/json-schema для валидации JSON-документов по схеме.
•	Программа должна загружать содержимое club-member-schema.json и bad-member-data.json из файлов.
•	Программа должна валидировать данные из bad-member-data.json по правилам, заданным в club-member-schema.json.
•	Если данные не соответствуют схеме (email невалидный), программа должна вывести на экран сообщение об ошибке формата email.
•	Сообщение об ошибке валидации должно явно указывать, что проблема связана с форматом email.

import org.everit.json.schema.Schema;
import org.everit.json.schema.ValidationException;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Solution {
    public static void main(String[] args) {
        // Пути к файлам схемы и данных
        var schemaPath = Paths.get("club-member-schema.json");
        var dataPath = Paths.get("bad-member-data.json");

        // Читаем оба файла и парсим JSON


            // Загружаем схему (правила допуска)


            // Загружаем данные "нарушителя"


            // Проводим строгую валидацию данных по схеме


            // Не углубляемся в обработку всех ошибок, выводим краткое сообщение

    }
}

 */
import org.everit.json.schema.Schema;
import org.everit.json.schema.ValidationException;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Solution {
    public static void main(String[] args) throws IOException {
        // Пути к файлам схемы и данных
        var schemaPath = Paths.get("club-member-schema.json");
        var dataPath = Paths.get("bad-member-data.json");

        String schemaContent = Files.readString(schemaPath);
        String dataContent = Files.readString(dataPath);
//        JSONObject json = new JSONObject(new JSONTokener(dataContent));
//        JSONObject rawSchema = new JSONObject(new JSONTokener(schemaContent));
//        Schema schema = SchemaLoader.load(rawSchema);

//        schema.validate(json); // Если всё ок — ничего не произойдет
        try {
            // Загружаем схему (правила допуска)
            JSONObject schemaTemplate = new JSONObject(schemaContent);


            // Загружаем данные "нарушителя"
            JSONObject json = new JSONObject(dataContent);

            // Проводим строгую валидацию данных по схеме
            Schema schema = SchemaLoader.load(schemaTemplate);
            schema.validate(json);
            System.out.println("Всё нормально!");
        } catch (Exception e) {
            // Не углубляемся в обработку всех ошибок, выводим краткое сообщение
            System.out.println("Неверный email " + e.getClass().getName());
        }


    }
}

/*

public class Solution {
    public static void main(String[] args) {
        // Пути к файлам схемы и данных (находятся в корне проекта)
        var schemaPath = Paths.get("club-member-schema.json");
        var dataPath = Paths.get("bad-member-data.json");

        // Читаем оба файла и парсим JSON
        try (InputStream schemaIS = Files.newInputStream(schemaPath);
             InputStream dataIS = Files.newInputStream(dataPath)) {

            // Загружаем схему (правила допуска)
            JSONObject rawSchema = new JSONObject(new JSONTokener(schemaIS));
            Schema schema = SchemaLoader.load(rawSchema); // сборка объекта схемы

            // Загружаем данные "нарушителя"
            JSONObject data = new JSONObject(new JSONTokener(dataIS));

            // Проводим строгую валидацию данных по схеме
            try {
                schema.validate(data); // если ошибок нет — метод завершится тихо
                System.out.println("Данные валидны: доступ разрешён.");
            } catch (ValidationException ve) {
                // Чёткое и понятное сообщение о проблеме с форматом email
                System.out.println("Ошибка: поле 'email' не соответствует формату email.");

                // Для наглядности выводим детали из библиотеки (поможет увидеть точную причину)
                System.out.println("Детали ошибки валидации:");
                for (String msg : ve.getAllMessages()) {
                    System.out.println(" - " + msg);
                }
            }

        } catch (IOException io) {
            // Не углубляемся в обработку всех ошибок, выводим краткое сообщение
            System.out.println("Не удалось прочитать файлы схемы или данных: " + io.getMessage());
        }
    }
}
 */