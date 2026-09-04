import java.io.FileInputStream;
import java.util.Arrays;

public class Bride {
    public static void main(String[] args) throws Exception
    {
        //создаем объект FileInputStream, привязанный к файлу «c:/data.txt».
        FileInputStream inputStream = new FileInputStream("D:\\ASProject\\Java_learning\\25_02_2025.txt");
        long sum = 0;

        while (inputStream.available() > 0) //пока остались непрочитанные байты
        {
            int data = inputStream.read(); //прочитать очередной байт
            sum += data; //добавить его к общей сумме
        }
        inputStream.close(); // закрываем поток

        System.out.println(sum); //выводим сумму на экран.
    }
    public static int[] digitize(int n) {
        // Code here
//        int[] myArr = new int[Math.toIntExact(n)];
        int[] myArr = new int[n];
        int i = 0;
        while (n > 0) {
            int lastDigit = n % 10; // Получаем последнюю цифру
            myArr[i] = lastDigit;
            i++;
//            System.out.println(lastDigit); // Выводим: 5, 4, 3, 2, 1
            n /= 10; // Убираем последнюю цифру
        }


//        for (int i = 0; i < myArr.length; i++) {
//            myArr[myArr.length - i] =
//        }
        return myArr;
    }

}
