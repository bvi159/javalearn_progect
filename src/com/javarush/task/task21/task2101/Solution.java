package com.javarush.task.task21.task2101;

/* 
Определяем адрес сети
public class Solution {
    public static void main(String[] args) {
        byte[] ip = new byte[]{(byte) 192, (byte) 168, 1, 2};
        byte[] mask = new byte[]{(byte) 255, (byte) 255, (byte) 254, 0};
        byte[] netAddress = getNetAddress(ip, mask);
        print(ip);          //11000000 10101000 00000001 00000010
        print(mask);        //11111111 11111111 11111110 00000000
        print(netAddress);  //11000000 10101000 00000000 00000000
    }

    public static byte[] getNetAddress(byte[] ip, byte[] mask) {
        byte[] netAddress = new byte[4];
        for (int i = 0; i < netAddress.length; i++)
            netAddress[i] = (byte) (ip[i] & mask[i]);
        return netAddress;
    }

    public static void print(byte[] bytes) {
        String currentBinary;
        for (byte aByte : bytes) {
            currentBinary = Integer.toBinaryString(256 + (int) aByte);
            System.out.print(currentBinary.substring(currentBinary.length() - 8) + " ");
        }
        System.out.println();
    }
}


1. Даны IP-адрес и маска подсети, необходимо вычислить адрес сети - реализуй метод getNetAddress.
Используй операцию поразрядной конъюнкции (логическое И).

Пример:
IP-адрес: 11000000 10101000 00000001 00000010 (192.168.1.2)
Маска подсети: 11111111 11111111 11111110 00000000 (255.255.254.0)
Адрес сети: 11000000 10101000 00000000 00000000 (192.168.0.0)

2. Реализовать метод print, который выведет в консоль данные в двоичном коде. Для IP-адреса(192.168.1.2)
должна быть выведена строка "11000000 10101000 00000001 00000010"
3. Метод main не участвует в тестировании

Требования:
•	Метод getNetAddress должен вычислять и возвращать адрес сети согласно переданным параметрам(IP-адрес и маска подсети).
•	Метод getNetAddress должен быть статическим и публичным.
•	Метод print должен быть статическим и публичным.
•	Метод print должен преобразовывать переданный ему IP адрес в двоичный код и выводить на экран(как в условии).


*/

import java.util.Arrays;

//Хорошее решение подсказал DeepSeek
public class Solution {
    public static void main(String[] args) {
        byte[] ip = new byte[]{(byte) 192, (byte) 168, 1, 2};
        byte[] mask = new byte[]{(byte) 255, (byte) 255, (byte) 254, 0};
        byte[] netAddress = getNetAddress(ip, mask);
        print(ip, "IP-адрес: ");          //11000000 10101000 00000001 00000010
        print(mask, "Маска подсети: ");        //11111111 11111111 11111110 00000000
        print(netAddress, "Адрес сети: ");  //11000000 10101000 00000000 00000000

    }

    public static byte[] getNetAddress(byte[] ip, byte[] mask) {
        // Вычисляем адрес сети побитовым AND между соответствующими октетами
        byte[] networkOctets = new byte[4];
        for (int i = 0; i < 4; i++) {
            networkOctets[i] = (byte) (ip[i] & mask[i]);
        }
//        return new byte[4];
        return networkOctets;
    }

    public static void print(byte[] bytes, String whatIsIt) {
            StringBuilder binaryString = new StringBuilder();
            binaryString.append(whatIsIt);
            for (int i = 0; i < 4; i++) {
                if (i > 0) binaryString.append(" ");
                String octet = String.format("%8s", Integer.toBinaryString(bytes[i] & 0xFF));
                octet = octet.replace(' ', '0');
                binaryString.append(octet);
//                System.out.println(bytes[i] & 0xFF);
            }
//            binaryString.append(")");
            //Тута делаем ip адрес типа 192.168.1.2
            String ip = String.format(" (%d.%d.%d.%d)",
                bytes[0] & 0xFF, bytes[1] & 0xFF,
                bytes[2] & 0xFF, bytes[3] & 0xFF);

            binaryString.append(ip);
//            return binaryString.toString();
            System.out.println(binaryString.toString());
//            System.out.println(Integer.toBinaryString(bytes[i])); // < 0 ? (bytes[i] + 255) : bytes[i]));
//        }

    }
}

 /*
String octet = String.format("%8s", Integer.toBinaryString(bytes[i] & 0xFF)).replace(' ', '0');
Эта строка преобразует один байт (октет) IP-адреса в 8-битное двоичное представление с ведущими нулями.
Рассмотрим по шагам:

bytes[i] & 0xFF:
В Java byte имеет диапазон -128..127 (знаковый тип)

& 0xFF преобразует байт в int (0..255), убирая знаковое расширение

Например, (byte)192 останется 192, а (byte)-64 станет 192

Integer.toBinaryString(...):

Преобразует число в строку с двоичным представлением

Например, 192 → "11000000", 1 → "1", 2 → "10"

String.format("%8s", ...):

Форматирует строку в поле шириной 8 символов

Если строка короче, добавляет пробелы слева

Например:

"11000000" → "11000000" (остаётся как есть)

"1" → " 1" (7 пробелов + "1")

.replace(' ', '0'):

Заменяет все пробелы на нули

Например:

"11000000" → "11000000" (без изменений)

" 1" → "00000001"

Примеры преобразования:

(byte)192 → "11000000"

(byte)1 → "00000001"

(byte)2 → "00000010"

(byte)0 → "00000000"

(byte)255 → "11111111"

Таким образом, эта строка гарантирует, что каждый октет будет представлен ровно 8 символами (8 битами),
даже если в числе меньше значащих битов, что важно для корректного отображения IP-адресов и масок подсети.

 */

/*
 // Выводим результат
        System.out.println("IP-адрес: " + ip + bytesToString(ip));
        System.out.println("Маска подсети: " + bytesToString(mask));
        System.out.println("Адрес сети: " + bytesToString(networkAddress));

Надо учесть что ip и mask заданы в массивами byte
byte[] ip = new byte[]{(byte) 192, (byte) 168, 1, 2};
byte[] mask = new byte[]{(byte) 255, (byte) 255, (byte) 254, 0};
и networkAdress нужно получить в виде массива byte

Java
Даны IP-адрес и маска подсети, необходимо вычислить адрес сети
Используй операцию поразрядной конъюнкции (логическое И).

Пример: IP-адрес: 11000000 10101000 00000001 00000010 (192.168.1.2)
Маска подсети: 11111111 11111111 11111110 00000000 (255.255.254.0)
Адрес сети: 11000000 10101000 00000000 00000000 (192.168.0.0)
 */