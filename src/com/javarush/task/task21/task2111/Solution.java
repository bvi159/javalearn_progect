package com.javarush.task.task21.task2111;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

/* 
Освобождаем ресурсы
*/
// Java нужно для примера сделать main для этой программы:

public class Solution {
    private Connection connection;

    public Solution(Connection connection) {
        this.connection = connection;
    }

    public List<User> getUsers() {
//        String query = "select ID, DISPLAYED_NAME, LEVEL, LESSON from USER";
        String query = "select ID, DISPLAYED_NAME, LEVEL, LESSON from \"USER\"";


        List<User> result = new LinkedList();

//        Statement stmt = null;
//        ResultSet rs = null;

        try (Statement stmt = connection.createStatement(); ResultSet rs =  stmt.executeQuery(query)) {
//            stmt = connection.createStatement();
//            rs = stmt.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("ID");
                String name = rs.getString("DISPLAYED_NAME");
                int level = rs.getInt("LEVEL");
                int lesson = rs.getInt("LESSON");

                result.add(new User(id, name, level, lesson));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            result = null;
        }
//        finally {
//            if (stmt != null) {
//                try {
//                    stmt.close();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
//            if (rs != null) {
//                try {
//                    rs.close();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
        return result;
    }

    @Override
    protected void finalize() throws Throwable {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Connection closed in finalize()");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            super.finalize();
        }
    }

    public static class User {
        private int id;
        private String name;
        private int level;
        private int lesson;

        public User(int id, String name, int level, int lesson) {
            this.id = id;
            this.name = name;
            this.level = level;
            this.lesson = lesson;
        }

        @Override
        public String toString() {
            return "User{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", level=" + level +
                    ", lesson=" + lesson +
                    '}';
        }
    }

    public static void main(String[] args) {
        // Используем H2 in-memory database для примера
        Connection connection = null;
        try {
            // Регистрируем драйвер H2
            Class.forName("org.h2.Driver");

            // Создаем соединение с базой данных
            connection = DriverManager.getConnection("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1", "sa", "");

            // Создаем таблицу USER и заполняем тестовыми данными
            try (Statement stmt = connection.createStatement()) {
                stmt.execute("CREATE TABLE \"USER\" (" +
                        "ID INT PRIMARY KEY, " +
                        "DISPLAYED_NAME VARCHAR(100), " +
                        "LEVEL INT, " +
                        "LESSON INT)");

                stmt.execute("INSERT INTO \"USER\" VALUES (1, 'John Doe', 5, 12)");
                stmt.execute("INSERT INTO \"USER\" VALUES (2, 'Jane Smith', 3, 8)");
                stmt.execute("INSERT INTO \"USER\" VALUES (3, 'Bob Johnson', 7, 15)");
            }

            // Создаем экземпляр Solution и получаем список пользователей
            Solution solution = new Solution(connection);
            List<User> users = solution.getUsers();

            // Выводим результат
            if (users != null) {
                System.out.println("Список пользователей:");
                for (User user : users) {
                    System.out.println(user);
                }
            } else {
                System.out.println("Ошибка при получении списка пользователей");
            }

        } catch (ClassNotFoundException e) {
            System.err.println("H2 драйвер не найден в classpath");
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Закрываем соединение
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
/*
public class Solution {
    private Connection connection;

    public Solution(Connection connection) {
        this.connection = connection;
    }

    public List<User> getUsers() {
        String query = "select ID, DISPLAYED_NAME, LEVEL, LESSON from USER";

        List<User> result = new LinkedList();

        Statement stmt = null;
        ResultSet rs = null;

        try {
            stmt = connection.createStatement();
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("ID");
                String name = rs.getString("DISPLAYED_NAME");
                int level = rs.getInt("LEVEL");
                int lesson = rs.getInt("LESSON");

                result.add(new User(id, name, level, lesson));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            result = null;
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    public static class User {
        private int id;
        private String name;
        private int level;
        private int lesson;

        public User(int id, String name, int level, int lesson) {
            this.id = id;
            this.name = name;
            this.level = level;
            this.lesson = lesson;
        }

        @Override
        public String toString() {
            return "User{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", level=" + level +
                    ", lesson=" + lesson +
                    '}';
        }
    }

    public static void main(String[] args) {

    }
}
 */