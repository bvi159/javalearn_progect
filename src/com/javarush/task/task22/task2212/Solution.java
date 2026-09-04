package com.javarush.task.task22.task2212;

/*


Проверка номера телефона

Метод checkTelNumber должен проверять, является ли аргумент telNumber валидным номером телефона.

Критерии валидности:
1) если номер начинается с '+', то он содержит 12 цифр
2) если номер начинается с цифры или открывающей скобки, то он содержит 10 цифр
3) может содержать 1 пару скобок '(' и ')'
4) скобки (если они есть) внутри содержат четко 3 цифры
5) номер может содержать только цифры, '+', '(' и ')'
6) номер заканчивается на цифру

Примеры:
+380501234567 - true
+38(050)1234567 - true
(050)1234567 - true
0(501)234567 - true
+38)050(1234567 - false
+38(050)123-45-67 - false
050ххх4567 - false
050123456 - false
(0)501234567 - false

Требования:
•	Метод checkTelNumber должен возвращать значение типа boolean.
•	Метод checkTelNumber должен быть публичным.
•	Метод checkTelNumber должен принимать один параметр типа String.
•	Метод checkTelNumber должен корректно проверять валидность номера телефона переданного ему в качестве параметра.

public class Solution {
    public static boolean checkTelNumber(String telNumber) {
        if (telNumber == null) {
            return false;
        }
        return (telNumber.matches("^\\+(\\d[()]?){12}$") || telNumber.matches("^([()]?\\d){10}$"))
                && telNumber.matches("^(\\+)?(\\d+)?(\\(\\d{3}\\))?\\d+$");
    }

    public static void main(String[] args) {

    }
}

*/
public class Solution {
    public static boolean checkTelNumber(String telNumber) {
        if (telNumber == null || telNumber.isEmpty()) {
            return false;
        }
// Комплексная регулярное выражение, учитывающая все требования:
        // 1. ^\\+\\d{2}\\(\\d{3}\\)\\d{7}$ - начинается с +, затем 2 цифры, (3 цифры), 7 цифр
        // 2. ^\\+\\d{12}$ - начинается с + и 12 цифр
        // 3. ^\\(\\d{3}\\)\\d{7}$ - начинается с (3 цифры) и 7 цифр
        // 4. ^\\d\\(\\d{3}\\)\\d{6}$ - начинается с цифры, затем (3 цифры) и 6 цифр
        // 5. ^\\d{10}$ - 10 цифр

//        String pattern = "^(\\+\\d{2}\\(\\d{3}\\)\\d{7}|" +
//                "\\+\\d{12}|" +
//                "\\(\\d{3}\\)\\d{7}|" +
//                "\\d\\(\\d{3}\\)\\d{6}|" +
//                "\\d{10})$";
        String pattern = "^(\\+\\d{2}\\(\\d{3}\\)\\d{7}|\\+\\d{12}|\\(\\d{3}\\)\\d{7}|\\d\\(\\d{3}\\)\\d{6}|\\d{10})$";



        /*
        // Проверка всех критериев с помощью регулярных выражений
        String pattern = "^\\+\\d{2}\\(\\d{3}\\)\\d{7}$|" + // +XX(XXX)XXXXXXX
                "^\\+\\d{12}$|" + // +XXXXXXXXXXXX
                "^\\(\\d{3}\\)\\d{7}$|" + // (XXX)XXXXXXX
                "^\\d\\(\\d{3}\\)\\d{6}$|" + // X(XXX)XXXXXX
                "^\\d{10}$"; // XXXXXXXXXX
         */

        return telNumber.matches(pattern);
    }

    // Тестирование
    public static void main(String[] args) {
        System.out.println(checkTelNumber("+380501234567")); // true
        System.out.println(checkTelNumber("+38(050)1234567")); // true
        System.out.println(checkTelNumber("(050)1234567")); // true
        System.out.println(checkTelNumber("0(501)234567")); // true
        System.out.println(checkTelNumber("+38)050(1234567")); // false
        System.out.println(checkTelNumber("+38(050)123-45-67")); // false
        System.out.println(checkTelNumber("050ххх4567")); // false
        System.out.println(checkTelNumber("050123456")); // false
        System.out.println(checkTelNumber("(0)501234567")); // false
    }
}
/*

public static boolean checkTelNumber(String telNumber) {
        if (telNumber == null || telNumber.isEmpty()) {
            return false;
        }

        // Проверка всех критериев с помощью регулярных выражений
        String pattern = "^\\+\\d{2}\\(\\d{3}\\)\\d{7}$|" + // +XX(XXX)XXXXXXX
                "^\\+\\d{12}$|" + // +XXXXXXXXXXXX
                "^\\(\\d{3}\\)\\d{7}$|" + // (XXX)XXXXXXX
                "^\\d\\(\\d{3}\\)\\d{6}$|" + // X(XXX)XXXXXX
                "^\\d{10}$"; // XXXXXXXXXX

        return telNumber.matches(pattern);
    }

public class Solution {
    public static boolean checkTelNumber(String telNumber) {
        return false;
    }

    public static void main(String[] args) {

    }
}

 */
