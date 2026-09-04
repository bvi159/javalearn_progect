package com.javarush.task.task23.task2309;

import com.javarush.task.task23.task2309.vo.*;

import java.util.List;

/* 
Анонимность иногда так приятна!
1. В пакете vo создай public классы User, Location, Server, Subject, Subscription, которые наследуются от NamedItem
2. В классе Solution для каждого класса создай свой метод, который возвращает список экземпляров класса.

Например, для класса User это будет - public List<User> getUsers()
Для класса Location это будет - public List<Location> getLocations()

3. Внутри каждого такого метода создай анонимный класс от AbstractDbSelectExecutor и вызови его нужный метод.

Подсказка:
тело метода должно начинаться так: return new AbstractDbSelectExecutor

4. Пример вывода для User и Location:
Id=5, name='User-5', description=Received from executing 'SELECT * FROM USER'
Id=1, name='Location-1', description=Received from executing 'SELECT * FROM LOCATION'

5. Проанализируй пример вывода и сформируй правильный query для всех классов.

Требования:
•	В пакете vo должен быть создан public класс User, унаследованный от класса NamedItem.
•	В пакете vo должен быть создан public класс Location, унаследованный от класса NamedItem.
•	В пакете vo должен быть создан public класс Server, унаследованный от класса NamedItem.
•	В пакете vo должен быть создан public класс Subject, унаследованный от класса NamedItem.
•	В пакете vo должен быть создан public класс Subscription, унаследованный от класса NamedItem.
•	В методе getUsers должен быть создан объект класса AbstractDbSelectExecutor с параметром типа User.
•	В методе getLocations должен быть создан объект класса AbstractDbSelectExecutor с параметром типа Location.
•	В методе getServers должен быть создан объект класса AbstractDbSelectExecutor с параметром типа Server.
•	В методе getSubjects должен быть создан объект класса AbstractDbSelectExecutor с параметром типа Subject.
•	В методе getSubscriptions должен быть создан объект класса AbstractDbSelectExecutor с параметром типа Subscription.
•	Метод getUsers должен возвращать корректный список(в соответствии с условием задачи).
•	Метод getLocations должен возвращать корректный список(в соответствии с условием задачи).
•	Метод getServers должен возвращать корректный список(в соответствии с условием задачи).
•	Метод getSubjects должен возвращать корректный список(в соответствии с условием задачи).
•	Метод getSubscriptions должен возвращать корректный список(в соответствии с условием задачи).

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        print(solution.getUsers());
        print(solution.getLocations());
        print(solution.getServers());
        print(solution.getSubjects());
        print(solution.getSubscriptions());
    }

    public static void print(List list) {
        String format = "Id=%d, name='%s', description=%s";
        for (Object obj : list) {
            NamedItem item = (NamedItem) obj;
            System.out.println(String.format(format, item.getId(), item.getName(), item.getDescription()));
        }
    }

    public List<User> getUsers() {
        return new AbstractDbSelectExecutor<User>() {
            @Override
            public String getQuery() {
                return ("select * from " + "User").toUpperCase();
            }
        }.execute();
    }


    public List<Location> getLocations() {
        return new AbstractDbSelectExecutor<Location>() {
            @Override
            public String getQuery() {
                return ("select * from " + "Location").toUpperCase();
            }
        }.execute();
    }

    public List<Server> getServers() {
        return new AbstractDbSelectExecutor<Server>() {
            @Override
            public String getQuery() {
                return ("select * from " + "Server").toUpperCase();
            }
        }.execute();
    }

    public List<Subject> getSubjects() {
        return new AbstractDbSelectExecutor<Subject>() {
            @Override
            public String getQuery() {
                return ("select * from " + "Subject").toUpperCase();
            }
        }.execute();
    }

    public List<Subscription> getSubscriptions() {
        return new AbstractDbSelectExecutor<Subscription>() {
            @Override
            public String getQuery() {
                return ("select * from " + "Subscription").toUpperCase();
            }
        }.execute();
    }
}

Практически тоже что и у меня
Остальные классы аналогичны.

*/

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        print(solution.getUsers());
        print(solution.getLocations());
    }

    public List<User> getUsers() {
        AbstractDbSelectExecutor<User> executor = new AbstractDbSelectExecutor<User>() {
            @Override
            public String getQuery() {
                return "SELECT * FROM USER";
            }
        };
        return executor.execute();
    }

    public List<Location> getLocations() {
        AbstractDbSelectExecutor<Location> executor = new AbstractDbSelectExecutor<Location>() {
            @Override
            public String getQuery() {
                return "SELECT * FROM LOCATION";
            }
        };
        return executor.execute();
    }

    public List<Server> getServers() {
        AbstractDbSelectExecutor<Server> executor = new AbstractDbSelectExecutor<Server>() {
            @Override
            public String getQuery() {
                return "SELECT * FROM SERVER";
            }
        };
        return executor.execute();
    }

    public List<Subject> getSubjects() {
        AbstractDbSelectExecutor<Subject> executor = new AbstractDbSelectExecutor<Subject>() {
            @Override
            public String getQuery() {
                return "SELECT * FROM SUBJECT";
            }
        };
        return executor.execute();
    }

    public List<Subscription> getSubscriptions() {
        AbstractDbSelectExecutor<Subscription> executor = new AbstractDbSelectExecutor<Subscription>() {
            @Override
            public String getQuery() {
                return "SELECT * FROM SUBSCRIPTION";
            }
        };
        return executor.execute();
    }

    public static void print(List list) {
        String format = "Id=%d, name='%s', description=%s";
        for (Object obj : list) {
            NamedItem item = (NamedItem) obj;
            System.out.println(String.format(format, item.getId(), item.getName(), item.getDescription()));
        }
    }
}

/*
И не существовало классов Location Server Subject Subscription и User

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        print(solution.getUsers());
        print(solution.getLocations());
    }

    public static void print(List list) {
        String format = "Id=%d, name='%s', description=%s";
        for (Object obj : list) {
            NamedItem item = (NamedItem) obj;
            System.out.println(String.format(format, item.getId(), item.getName(), item.getDescription()));
        }
    }
}


 */