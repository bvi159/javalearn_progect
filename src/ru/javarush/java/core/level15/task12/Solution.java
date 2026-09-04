package ru.javarush.java.core.level15.task12;
/*
Строгая проверка возраста в школьной базе данных 🏫

Вы отвечаете за целостность данных в школьной базе. Очень важно, чтобы возраст учеников всегда был корректным — очевидно, он не может быть отрицательным. Система должна уметь отсеивать некорректные данные при попытке их ввода.
Создайте класс SchoolStudent. Внутри него объявите приватное поле currentAge типа int.
Реализуйте публичный геттер getCurrentAge() для получения возраста. Самое главное — реализуйте сеттер setCurrentAge(int potentialAge). Внутри этого сеттера добавьте проверку: если переданное значение potentialAge отрицательное, то поле currentAge не должно изменяться. Вместо этого выведите на экран строгое сообщение: "Внимание! Возраст студента не может быть отрицательным. Значение не обновлено.". Если же potentialAge корректное (неотрицательное), тогда обновите поле currentAge.
В классе Solution создайте объект SchoolStudent, возможно, с начальным возрастом 10. Затем попробуйте установить ему возраст -5. После этой попытки сразу же выведите текущий возраст студента на экран, используя геттер, чтобы убедиться, что он не изменился. Затем попробуйте установить возраст 15 и снова выведите его на экран, чтобы подтвердить, что корректное значение успешно обновилось.

Требования:
•	В классе SchoolStudent должно быть объявлено приватное поле currentAge типа int.
•	В классе SchoolStudent должен быть реализован публичный метод getCurrentAge(), возвращающий текущее значение поля currentAge.
•	В классе SchoolStudent должен быть реализован публичный метод setCurrentAge(int potentialAge), который обновляет поле currentAge только если potentialAge неотрицательное.
•	Если в метод setCurrentAge передано отрицательное значение, поле currentAge не должно изменяться, а на экран должно выводиться сообщение: "Внимание! Возраст студента не может быть отрицательным. Значение не обновлено."
•	В классе Solution должен быть создан объект SchoolStudent (например, с возрастом 10), после чего должны быть выполнены попытки установить возраст -5 и 15 с последующим выводом значения возраста через геттер после каждой попытки.

public class Solution {
    public static void main(String[] args) {
        // Создаем студента с начальным возрастом 10
        SchoolStudent student = new SchoolStudent(10);

        // Пытаемся установить отрицательный возраст
        student.setCurrentAge(-5);

        // Проверяем, что возраст не изменился — выводим через геттер
        System.out.println(student.getCurrentAge());

        // Устанавливаем корректный возраст
        student.setCurrentAge(15);

        // Проверяем, что возраст обновился
        System.out.println(student.getCurrentAge());
    }
}

 */

import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        // Создаем студента с начальным возрастом 10
        SchoolStudent student = new SchoolStudent(10);

        // Пытаемся установить отрицательный возраст
        student.setCurrentAge(-5);

        // Проверяем, что возраст не изменился — выводим через геттер
        System.out.println(student.getCurrentAge());

        // Устанавливаем корректный возраст
        student.setCurrentAge(15);

        // Проверяем, что возраст обновился
        System.out.println(student.getCurrentAge());
        // Map<String, String> envs = System.getenv();

        System.getenv().forEach((key, value) ->
                System.out.println(key + "=" + value)
        );
    }
}

class SchoolStudent {
    private int currentAge;

    public SchoolStudent(int age) {
        this.currentAge = age;
    }

    public int getCurrentAge() {
        return this.currentAge;
    }

    public void setCurrentAge(int potentialAge) {
        if (potentialAge < 0) {
            System.out.println("Внимание! Возраст студента не может быть отрицательным. Значение не обновлено.");
            return;
        }
        this.currentAge = potentialAge;
    }

}