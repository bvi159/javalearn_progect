package ru.javarush.java.core.level10.task16;
/*
Навигация в космическом путешествии 🚀
Представьте, что вы капитан космического корабля, исследующего Солнечную систему. Вам нужно уметь идентифицировать планеты, знать их названия, их "порядковый номер" (для упрощения навигации) и уметь быстро "наводить" корабль на цель, получив название планеты в виде строки.

Для этого объявите перечисление CelestialBody с тремя значениями: EARTH, MARS, JUPITER. В методе main выполните следующие шаги:

Создайте переменную типа CelestialBody и присвойте ей значение MARS, так как это ваше текущее направление.
Выведите на экран официальное имя этой планеты, используя специальный метод name().
Выведите её "порядковый номер" в списке перечисления, используя метод ordinal().
Затем, представьте, что центр управления прислал вам новую цель в виде строки "JUPITER". Преобразуйте эту строку в значение перечисления CelestialBody, используя метод valueOf(), и выведите это новое значение на экран, подтверждая, что навигация успешно переключена.
Требования:
•	В программе должно быть объявлено перечисление CelestialBody с тремя значениями: EARTH, MARS, JUPITER.
•	В методе main должна быть создана переменная типа CelestialBody и ей должно быть присвоено значение MARS.
•	Для вывода официального имени текущей планеты должен быть использован метод name().
•	Для вывода порядкового номера текущей планеты в перечислении должен быть использован метод ordinal().
•	Строка "JUPITER" должна быть преобразована в значение перечисления CelestialBody с помощью метода valueOf().
•	После преобразования строки "JUPITER" в значение перечисления результат должен быть выведен на экран для подтверждения переключения навигации.
// Перечисление космических тел с фиксированными значениями


public class Solution {
    public static void main(String[] args) {
        // 1) Создаем переменную типа CelestialBody и присваиваем ей MARS


        // 2) Выводим официальное имя текущей планеты через специальный метод name()


        // 3) Выводим "порядковый номер" текущей планеты через метод ordinal()


        // 4) Преобразуем строку "JUPITER" в значение перечисления через valueOf()
        String incoming = "JUPITER";


        // Выводим новое значение enum для подтверждения переключения

    }
}
 */
// Перечисление космических тел с фиксированными значениями


public class Solution {
    public static void main(String[] args) {
        // 1) Создаем переменную типа CelestialBody и присваиваем ей MARS
        CelestialBody somePlanet = CelestialBody.MARS;

        // 2) Выводим официальное имя текущей планеты через специальный метод name()
        System.out.println(somePlanet.name());

        // 3) Выводим "порядковый номер" текущей планеты через метод ordinal()
        System.out.println(somePlanet.ordinal());

        // 4) Преобразуем строку "JUPITER" в значение перечисления через valueOf()
        String incoming = "JUPITER";
        try {
            somePlanet = CelestialBody.valueOf(incoming);
            System.out.println(somePlanet);
        } catch (IllegalArgumentException e) {
//            throw new RuntimeException(e);
            System.out.println("Нет такой планеты " + incoming);
        }

        // Выводим новое значение enum для подтверждения переключения

    }

}
/*
Ихнее решение
// Перечисление космических тел с фиксированными значениями
enum CelestialBody {
    EARTH, MARS, JUPITER
}

public class Solution {
    public static void main(String[] args) {
        // 1) Создаем переменную типа CelestialBody и присваиваем ей MARS
        CelestialBody current = CelestialBody.MARS;

        // 2) Выводим официальное имя текущей планеты через специальный метод name()
        System.out.println(current.name());

        // 3) Выводим "порядковый номер" текущей планеты через метод ordinal()
        System.out.println(current.ordinal());

        // 4) Преобразуем строку "JUPITER" в значение перечисления через valueOf()
        String incoming = "JUPITER";
        CelestialBody newTarget = CelestialBody.valueOf(incoming);

        // Выводим новое значение enum для подтверждения переключения
        System.out.println(newTarget);
    }
}
 */