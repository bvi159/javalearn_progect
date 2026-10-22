package ru.javarush.java.core.level46.task09;
/*

Инспекция новых пользовательских досье 🧐
Представьте, что вы — главный инспектор по данным в вашей корпорации. Каждое новое пользовательское досье, поступающее в систему, должно строго соответствовать утверждённому регламенту, иначе вся база данных может пойти под откос.

Ваша первая задача — создать регламент в виде файла "user-profile-schema.json". Этот файл должен описывать, что каждое досье должно быть объектом, содержащим обязательные поля "id" (целое число) и "name" (строка).

Содержание файла "user-profile-schema.json":

{
  "type": "object",
  "properties": {
    "id": { "type": "integer" },
    "name": { "type": "string" }
  },
  "required": ["id", "name"]
}
Затем создайте реальное пользовательское досье — файл "new-user-profile.json" — с данными, которые, как вы надеетесь, соответствуют регламенту:

{
  "id": 10,
  "name": "Bob"
}
Теперь напишите программу на Java. Ваша миссия — использовать библиотеку "everit-org/json-schema", чтобы загрузить ваш регламент и досье из файлов и тщательно проверить, соответствует ли досье установленным правилам.

Если всё в порядке и досье полностью валидно, программа должна торжественно объявить на экране: "Досье пользователя валидно! Данные в порядке!"

Требования:
•	Необходимо создать файл user-profile-schema.json, в котором должна быть корректно описана JSON Schema с обязательными полями id (integer) и name (string).
•	Необходимо создать файл new-user-profile.json, содержащий объект с полями id: 10 и name: "Bob".
•	Программа должна корректно загружать содержимое user-profile-schema.json и new-user-profile.json из файловой системы.
•	Для валидации досье по схеме необходимо использовать библиотеку everit-org/json-schema.
•	Программа должна валидировать содержимое new-user-profile.json на соответствие правилам, описанным в user-profile-schema.json.
•	Если досье валидно, программа должна вывести на экран сообщение: "Досье пользователя валидно! Данные в порядке!".

import org.everit.json.schema.Schema;
import org.everit.json.schema.ValidationException;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Solution {
    public static void main(String[] args) {
        // Пути к файлам. Ожидаем запуск из корня проекта (папки myproject).
        Path schemaPath = Path.of("user-profile-schema.json");
        Path dataPath = Path.of("new-user-profile.json");

        try {
            // Читаем содержимое файлов целиком строками (UTF-8 по умолчанию для Files.readString)
            String schemaContent = Files.readString(schemaPath);
            String dataContent = Files.readString(dataPath);

            // Парсим строки в объекты JSONObject


            // Создаем объект схемы (валидатор)
            // SchemaLoader понимает JSON-объект со структурой JSON Schema


            // Пытаемся провалидировать данные. В случае ошибок будет брошено ValidationException


            // Если исключения не было — данные валидны
            System.out.println("Досье пользователя валидно! Данные в порядке!");
        } catch (ValidationException ve) {
            // В учебной задаче достаточно кратко сообщить об ошибке
            System.out.println("Досье пользователя НЕ валидно: " + ve.getMessage());
        } catch (IOException ioe) {
            // Если не удалось прочитать файлы — сообщаем и завершаемся
            System.out.println("Ошибка чтения файлов: " + ioe.getMessage());
        }
    }
}

 */
import org.everit.json.schema.Schema;
import org.everit.json.schema.ValidationException;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Solution {
    public static void main(String[] args) {
        // Пути к файлам. Ожидаем запуск из корня проекта (папки myproject).
        Path schemaPath = Path.of("user-profile-schema.json");
        Path dataPath = Path.of("new-user-profile.json");

        try {
            // Читаем содержимое файлов целиком строками (UTF-8 по умолчанию для Files.readString)
            String schemaContent = Files.readString(schemaPath);
            String dataContent = Files.readString(dataPath);

            // Парсим строки в объекты JSONObject
            JSONObject json = new JSONObject(new JSONTokener(dataContent));

            // Создаем объект схемы (валидатор)
            // SchemaLoader понимает JSON-объект со структурой JSON Schema
            JSONObject rawSchema = new JSONObject(new JSONTokener(schemaContent));
            Schema schema = SchemaLoader.load(rawSchema);


            // Пытаемся провалидировать данные. В случае ошибок будет брошено ValidationException
            schema.validate(json); // Если всё ок — ничего не произойдет

            // Если исключения не было — данные валидны
            System.out.println("Досье пользователя валидно! Данные в порядке!");
        } catch (ValidationException ve) {
            // В учебной задаче достаточно кратко сообщить об ошибке
            System.out.println("Досье пользователя НЕ валидно: " + ve.getMessage());
        } catch (IOException ioe) {
            // Если не удалось прочитать файлы — сообщаем и завершаемся
            System.out.println("Ошибка чтения файлов: " + ioe.getMessage());
        }
    }
}

/*
package ru.javarush.java.core.level46.task09;

import org.everit.json.schema.Schema;
import org.everit.json.schema.ValidationException;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Solution {
    public static void main(String[] args) {
        // Пути к файлам. Ожидаем запуск из корня проекта (папки myproject).
        Path schemaPath = Path.of("user-profile-schema.json");
        Path dataPath = Path.of("new-user-profile.json");

        try {
            // Читаем содержимое файлов целиком строками (UTF-8 по умолчанию для Files.readString)
            String schemaContent = Files.readString(schemaPath);
            String dataContent = Files.readString(dataPath);

            // Парсим строки в объекты JSONObject
            JSONObject rawSchemaJson = new JSONObject(schemaContent);
            JSONObject userDataJson = new JSONObject(dataContent);

            // Создаем объект схемы (валидатор)
            // SchemaLoader понимает JSON-объект со структурой JSON Schema
            Schema schema = SchemaLoader.load(rawSchemaJson);

            // Пытаемся провалидировать данные. В случае ошибок будет брошено ValidationException
            schema.validate(userDataJson);

            // Если исключения не было — данные валидны
            System.out.println("Досье пользователя валидно! Данные в порядке!");
        } catch (ValidationException ve) {
            // В учебной задаче достаточно кратко сообщить об ошибке
            System.out.println("Досье пользователя НЕ валидно: " + ve.getMessage());
        } catch (IOException ioe) {
            // Если не удалось прочитать файлы — сообщаем и завершаемся
            System.out.println("Ошибка чтения файлов: " + ioe.getMessage());
        }
    }
}
 */