package com.javarush.task.task22.task2208;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/* 
Формируем WHERE
Сформируй часть запроса WHERE используя StringBuilder.
Если значение null, то параметр не должен попадать в запрос.

Пример:
{name=Ivanov, country=Ukraine, city=Kiev, age=null}

Результат:
name = 'Ivanov' and country = 'Ukraine' and city = 'Kiev'

Требования:
•	Метод getQuery должен принимать один параметр типа Map.
•	Метод getQuery должен иметь тип возвращаемого значения String.
•	Метод getQuery должен быть статическим.
•	Метод getQuery должен возвращать строку сформированную по правилам описанным в условии задачи.

public class Solution {
    public static void main(String[] args) {
        Map<String, String> paramsMap = new LinkedHashMap<>();
        paramsMap.put("name", "Ivanov");
        paramsMap.put("country", "Ukraine");
        paramsMap.put("city", "Kiev");
        paramsMap.put("age", null);

        System.out.println(getQuery(paramsMap));
    }

    public static String getQuery(Map<String, String> params) {
        StringBuilder queryBuilder = new StringBuilder();
        for (String s : params.keySet()) {
            String value = params.get(s);
            if (value == null) {
                continue;
            }
            if (queryBuilder.toString().length() != 0) {
                queryBuilder.append(" and ");
            }
            queryBuilder.append(s + " = '" + value + "'");
        }
        return queryBuilder.toString();
    }
}

Моя версия с помощью ИИ учитывает возможность использования " ' " одинарных кавычек в
данных, что может испортить SQL запрос.

*/

public class Solution {
    // Пример использования
    public static void main(String[] args) {
        Map<String, String> params = new LinkedHashMap<>();
        params.put("name", "Ivanov");
        params.put("country", "Ukraine");
        params.put("city", "Kiev");
        params.put("age", null);
        params.put("name", "Petrov");
        params.put("country", "Russia");
        params.put("city", "Moskow");
        params.put("age", "55");

        String whereClause = getQuery(params);
        System.out.println(whereClause);
        // Вывод: name = 'Ivanov' and country = 'Ukraine' and city = 'Kiev'
    }

    public static String getQuery(Map<String, String> params) {
            if (params == null || params.isEmpty()) {
                return "";
            }

            StringBuilder whereClause = new StringBuilder();
            boolean firstCondition = true;

            for (Map.Entry<String, String> entry : params.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();

                // Пропускаем null и пустые значения
                if (value == null || value.trim().isEmpty()) {
                    continue;
                }

                if (!firstCondition) {
                    whereClause.append(" and "); // Добавлены пробелы вокруг "and"
                }

                // Добавляем условие с экранированием кавычек
                whereClause.append(key).append(" = '").append(escapeQuotes(value)).append("'");
                firstCondition = false;
            }

            return whereClause.toString();
        }

        // Метод для экранирования кавычек в строковых значениях
        private static String escapeQuotes(String value) {
            return value.replace("'", "''");
        }
}
/*
    public static String getQuery(Map<String, String> params) {
//    public static String buildWhereClause(Map<String, String> params) {
        StringBuilder queryBuilder = new StringBuilder();
        for (String s : params.keySet()) {
            String value = params.get(s);
            if (value == null) {
                continue;
            }
            if (queryBuilder.toString().length() != 0) {
                queryBuilder.append(" and ");
            }
            queryBuilder.append(s + " = '" + value + "'");
        }
        return queryBuilder.toString();
    }

*/
/*
ublic class Solution {
    public static void main(String[] args) {

    }

    public static String getQuery(Map<String, String> params) {

        return null;
    }
}
 */