package com.javarush.task.task24.task2407;

import java.util.List;

/* 
Реализация интерфейса используя локальный класс
*/

public class Solution {
    public static void main(String[] args) {
        List<Pet> pet = Util.getPets();
        List<Sayable> pets = Util.convertPetToSayable(pet);
        Util.printDialog(pets);
    }
}

/*
  String code = "ваш код с JavaDoc здесь";

        CompilationUnit cu = StaticJavaParser.parse(code);

        cu.getAllContainedComments().stream()
                .filter(Comment::isJavadocComment)
                .forEach(System.out::println);

 */