package ru.javarush.java.core.level08.task18;
/*
Сверхсекретный банковский счет клиента
Вы — главный программист в сверхсекретном банке, и безопасность денежных средств клиентов для вас превыше всего! Баланс каждого счета — это святая святых, и к нему не должно быть прямого доступа извне.

Создайте класс CustomerBankAccount. Внутри него объявите приватное поле accountBalance типа int — это будет текущий баланс счета. Поскольку accountBalance приватное, прямой доступ к нему будет заблокирован для всех, кто не внутри самого класса.

Чтобы обеспечить контролируемое пополнение счета, реализуйте публичный метод depositMoney(int amountToDeposit), который позволит безопасно и строго через определенную процедуру изменить accountBalance.

В главном офисе банка, в методе main, создайте новый счет: myPrivateAccount = new CustomerBankAccount(). Используя только что созданный depositMoney, пополните счет на 1000.

Теперь, из любопытства или по ошибке, попробуйте напрямую обратиться к полю myPrivateAccount.accountBalance и присвоить ему значение 2000. Вы сразу увидите, как система безопасности выдаст предупреждение (ошибку компиляции).

Требования:
•	В классе CustomerBankAccount должно быть объявлено приватное поле accountBalance типа int.
•	Поле accountBalance не должно быть доступно напрямую вне класса CustomerBankAccount (компилятор должен выдавать ошибку при попытке обращения).
•	В классе CustomerBankAccount должен быть реализован публичный метод depositMoney(int amountToDeposit), который увеличивает значение accountBalance на указанную сумму.
•	В методе main должен быть создан объект класса CustomerBankAccount с именем myPrivateAccount.
•	В методе main необходимо вызвать метод depositMoney у объекта myPrivateAccount с аргументом 1000 для пополнения счета.
•	Попытка присвоить значение полю myPrivateAccount.accountBalance вне класса CustomerBankAccount должна приводить к ошибке компиляции.

// Главный офис банка с методом main
public class Solution {
    public static void main(String[] args) {
        // Создаем объект класса CustomerBankAccount с именем myPrivateAccount


        // Пополняем баланс только через публичный метод


        // Попытка прямого доступа к приватному полю извне класса:

    }
}

// Класс секретного банковского счета клиента
class CustomerBankAccount {
    // Приватное поле — к нему нельзя обращаться напрямую из других классов
    private int accountBalance;

    // Публичный метод для контролируемого пополнения счета
    public void depositMoney(int amountToDeposit) {
        // Увеличиваем баланс на указанную сумму
        accountBalance += amountToDeposit;
    }
}


 */

// Главный офис банка с методом main
public class Solution {
    public static void main(String[] args) {
        // Создаем объект класса CustomerBankAccount с именем myPrivateAccount
        CustomerBankAccount myPrivateAccount = new CustomerBankAccount();

        // Пополняем баланс только через публичный метод
        myPrivateAccount.depositMoney(1000);

        // Попытка прямого доступа к приватному полю извне класса:
        // myPrivateAccount.accountBalance = 2000;

    }
}

// Класс секретного банковского счета клиента
class CustomerBankAccount {
    // Приватное поле — к нему нельзя обращаться напрямую из других классов
    private int accountBalance;

    // Публичный метод для контролируемого пополнения счета
    public void depositMoney(int amountToDeposit) {
        // Увеличиваем баланс на указанную сумму
        accountBalance += amountToDeposit;
    }
}