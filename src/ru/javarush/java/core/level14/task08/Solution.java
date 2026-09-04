package ru.javarush.java.core.level14.task08;
/*
Управление банковскими счетами
Вы — главный разработчик в новом цифровом банке, и ваша задача — создать основу для клиентских счетов. Вам нужно предусмотреть разные сценарии создания счетов: кто-то хочет сразу положить деньги, а кто-то просто открыть счёт "пустым", чтобы пополнить позже. Кроме того, ваши клиенты должны иметь возможность пополнять свой баланс и получать актуальную информацию о состоянии своего счёта.

Создайте класс BankAccount с полями для имени владельца (String accountOwner) и текущего баланса (int accountBalance).

Реализуйте два способа открытия счёта (конструктора):

Один, который позволяет сразу указать имя владельца и начальный баланс,
и другой, который принимает только имя владельца, автоматически устанавливая начальный баланс в 0.
Добавьте метод deposit(int amount), который позволит клиенту положить указанную сумму на счёт, увеличив его баланс. И, конечно, метод printInfo(), который будет выводить на экран: "Владелец: [имя владельца], баланс: [текущий баланс]".

В вашем основном сценарии (main методе) откройте два счёта: один с уже заданным начальным балансом, а другой — только с именем. Затем пополните второй счёт на 500 единиц с помощью метода deposit(). В завершение, покажите информацию о состоянии каждого счёта, вызвав для них метод printInfo().

Требования:
•	Необходимо создать класс с именем BankAccount.
•	Класс BankAccount должен содержать два поля: String accountOwner и int accountBalance.
•	В классе BankAccount должно быть два конструктора: один принимает имя владельца и начальный баланс, другой только имя владельца (в этом случае баланс устанавливается в 0).
•	В классе должен быть метод deposit(int amount), который увеличивает поле accountBalance на переданную сумму.
•	В классе должен быть метод printInfo(), который выводит строку в формате: "Владелец: [имя владельца], баланс: [текущий баланс]".
•	В методе main нужно создать два объекта BankAccount: один с указанием имени и баланса, второй — только с именем.
•	В main-методе необходимо пополнить второй счет на 500 с помощью deposit(), затем вывести информацию о каждом счете с помощью printInfo().

public class Solution {
    public static void main(String[] args) {
        // Открываем счёт с заданным начальным балансом


        // Открываем счёт только с именем (баланс будет установлен в 0)


        // Пополняем второй счёт на 500 единиц


        // Выводим информацию о каждом счёте

    }
}

// Класс банковского счёта с владельцем и текущим балансом

 */

public class Solution {
    public static void main(String[] args) {
        // Открываем счёт с заданным начальным балансом
        BankAccount numberOne = new BankAccount("Guttenberg", 2000);

        // Открываем счёт только с именем (баланс будет установлен в 0)
        BankAccount numberTwo = new BankAccount("Frankenstein");

        // Пополняем второй счёт на 500 единиц
        numberTwo.deposit(500);


        // Выводим информацию о каждом счёте
        numberOne.printInfo();
        numberTwo.printInfo();

    }
}

// Класс банковского счёта с владельцем и текущим балансом
class BankAccount {

    String accountOwner;
    int accountBalance;

    public BankAccount(String accountOwner, int accountBalance) {
        this.accountOwner = accountOwner;
        this.accountBalance = accountBalance;
    }

    public BankAccount(String accountOwner) {
        this.accountOwner = accountOwner;
        this.accountBalance = 0;
    }

    public void deposit(int amount) {
        this.accountBalance += amount;

    }

    public void printInfo() {
        System.out.println("Владелец: " + this.accountOwner+", баланс: "+this.accountBalance);
    }
}
/*
Ихнее решение

public class Solution {
    public static void main(String[] args) {
        // Открываем счёт с заданным начальным балансом
        BankAccount first = new BankAccount("Алиса", 1000);

        // Открываем счёт только с именем (баланс будет установлен в 0)
        BankAccount second = new BankAccount("Боб");

        // Пополняем второй счёт на 500 единиц
        second.deposit(500);

        // Выводим информацию о каждом счёте
        first.printInfo();
        second.printInfo();
    }
}

// Класс банковского счёта с владельцем и текущим балансом
class BankAccount {
    // Поля по условию задачи
    String accountOwner;   // имя владельца
    int accountBalance;    // текущий баланс

    // Конструктор: имя владельца + начальный баланс
    BankAccount(String accountOwner, int accountBalance) {
        this.accountOwner = accountOwner;
        this.accountBalance = accountBalance;
    }

    // Конструктор: только имя владельца, баланс по умолчанию = 0
    BankAccount(String accountOwner) {
        // Делегируем основному конструктору, чтобы не дублировать логику
        this(accountOwner, 0);
    }

    // Пополнение счёта: увеличиваем баланс на указанную сумму
    void deposit(int amount) {
        accountBalance += amount;
    }

    // Печать информации в требуемом формате
    void printInfo() {
        System.out.println("Владелец: " + accountOwner + ", баланс: " + accountBalance);
    }
}

 */
