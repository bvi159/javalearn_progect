package com.javarush.task.task21.task2107;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/* 
Глубокое клонирование карты
public class Solution implements Cloneable {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.users.put("Hubert", new User(172, "Hubert"));
        solution.users.put("Zapp", new User(41, "Zapp"));
        Solution clone = null;
        try {
            clone = (Solution) solution.clone();
            System.out.println(solution);
            System.out.println(clone);

            System.out.println(solution.users);
            System.out.println(clone.users);

        } catch (CloneNotSupportedException e) {
            e.printStackTrace(System.err);
        }
    }

    protected Map<String, User> users = new LinkedHashMap<>();

    public static class User implements Cloneable {
        int age;
        String name;

        public User(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            User user = (User) o;

            if (age != user.age) return false;
            return name != null ? name.equals(user.name) : user.name == null;
        }

        @Override
        public int hashCode() {
            int result = age;
            result = 31 * result + (name != null ? name.hashCode() : 0);
            return result;
        }
    }

    public Object clone() throws CloneNotSupportedException {
        Solution o = (Solution) super.clone();

        //clone users
        Map<String, User> newUsers = new LinkedHashMap<>();
        for (String key : o.users.keySet()) {
            User user = o.users.get(key);
            newUsers.put(key, (User) user.clone());
        }
        o.users = newUsers;

        return o;
    }
}

Обеспечь возможность клонирования объекта класса Solution используя глубокое клонирование.
Данные в карте users также должны быть клонированы.
Не забудь о методах equals и hashCode для корректного добавления элементов типа User в HashMap.

Требования:
•	Класс Solution должен поддерживать интерфейс Cloneable.
•	Класс User должен поддерживать интерфейс Cloneable.
•	В классе User должен быть корректно реализован метод clone.
•	В классе Solution должен быть корректно реализован метод clone.

Моё решение тоже правильное - с помощью ИИ
*/

public class Solution implements Cloneable {
    protected Map<String, User> users = new LinkedHashMap();
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.users.put("Hubert", new User(172, "Hubert"));
        solution.users.put("Zapp", new User(41, "Zapp"));
        Solution clone = null;
        try {
            clone = (Solution) solution.clone();
            System.out.println(solution);
            System.out.println(clone);

            System.out.println(solution.users);
            System.out.println(clone.users);

        } catch (CloneNotSupportedException e) {
            e.printStackTrace(System.err);
        }
    }

    @Override
    public Solution clone() throws CloneNotSupportedException {
        Solution cloned = (Solution) super.clone(); // cloned - новый объект Solution
        // клонированный Solution
        // Глубокое копирование Map
        cloned.users = new LinkedHashMap<>();
        for (Map.Entry<String, User> entry : this.users.entrySet()) {
            cloned.users.put(entry.getKey(), entry.getValue().clone());
        }
        return cloned;
    }

    public static class User implements Cloneable {
        int age;
        String name;

        public User(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public User clone() {
            try {
                return (User) super.clone();
            } catch (CloneNotSupportedException e) {
                throw new AssertionError(); // Не должно произойти
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            User user = (User) o;
            return age == user.age && name.equals(user.name);
        }

        @Override
        public int hashCode() {
//            return 31 * age + name.hashCode();
            return Objects.hash(age, name);
        }

        @Override
        public String toString() {
            return "User{" +
                    "age=" + age +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
    @Override
    public String toString() {
        return "Solution{" +
                "users=" + users +
                '}';
    }
}

/*


// java не корректно клонируется объект в программе:
public class Solution imlements Cloneble {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.users.put("Hubert", new User(172, "Hubert"));
        solution.users.put("Zapp", new User(41, "Zapp"));
        Solution clone = null;
        try {
            clone = (Solution) solution.clone();
            System.out.println(solution);
            System.out.println(clone);

            System.out.println(solution.users);
            System.out.println(clone.users);

        } catch (CloneNotSupportedException e) {
            e.printStackTrace(System.err);
        }
    }

    protected Map<String, User> users = new LinkedHashMap();

    public static class User imlements Cloneble {
        int age;
        String name;

        public User(int age, String name) {
            this.age = age;
            this.name = name;
        }
    }
}
 */