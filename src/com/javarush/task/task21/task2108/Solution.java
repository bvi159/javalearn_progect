package com.javarush.task.task21.task2108;

/* 
Клонирование растений
public class Solution {
    public static void main(String[] args) {
        Tree tree = new Tree("willow", new String[]{"s1", "s2", "s3", "s4"});
        Tree clone = null;
        try {
            clone = (Tree) tree.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        System.out.println(tree);
        System.out.println(clone);

        System.out.println(tree.branches);
        System.out.println(clone.branches);
    }

    public static class Plant {
        private String name;

        public Plant(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public static class Tree extends Plant implements Cloneable {
        private String[] branches;

        public Tree(String name, String[] branches) {
            super(name);
            this.branches = branches;
        }

        public String[] getBranches() {
            return branches;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return new Tree(getName(), branches == null ? null : branches.clone());
        }
    }
}
Класс Plant не должен реализовывать интерфейс Cloneable
Реализуй механизм глубокого клонирования для Tree.

Требования:
•	Класс Plant не должен поддерживать интерфейс Cloneable.
•	Класс Tree должен поддерживать интерфейс Cloneable.
•	Класс Tree должен быть потомком класса Plant.
•	В классе Tree должен быть корректно реализован метод clone.

моё решение тоже правильное с помощью ИИ

*/

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

// java массив branches клонированного объекта должен быть равен массиву клонируемого объекта
public class Solution {
    public static void main(String[] args) {
        Tree tree = new Tree("willow", new String[]{"s1", "s2", "s3", "s4"});
        Tree clone = null;
        try {
            clone = (Tree) tree.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        System.out.println(tree);
        System.out.println(clone);

        System.out.println(Arrays.toString(tree.branches));
        System.out.println(Arrays.toString(clone.branches));
    }

    public static class Plant {
        private String name;

        public Plant(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public static class Tree extends Plant implements Cloneable {
        private String[] branches;

        public Tree(String name, String[] branches) {
            super(name);
            this.branches = branches;
        }

        public String[] getBranches() {
            return branches;
        }

        @Override
        public Object clone() throws CloneNotSupportedException {
            Tree treeCloned = (Tree) super.clone(); // cloned - новый объект Solution
            // клонированный Solution
            // Глубокое копирование Map
//            cloned.users = new LinkedHashMap<>();
//            treeCloned.branches = new String[]{"s1", "s2", "s3", "s4"};
//            treeCloned.branches = new String[super(getName().getBranches()).length()];
//            int clonedBranches = branches.length;
//            treeCloned.branches = new String[clonedBranches];
            treeCloned.branches = this.branches.clone();
//            for (Map.Entry<String, com.javarush.task.task21.task2107.Solution.User> entry : this.users.entrySet()) {
//                cloned.users.put(entry.getKey(), entry.getValue().clone());
//            }
//            return cloned;
//            return super.clone();

            return  treeCloned;
        }

        @Override
        public int hashCode() {
            return Objects.hash(getName(), getBranches());
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Tree mycloneTree = (Tree) obj;
//            if (this.branches.equals(mycloneTree.branches)) return true;
            return branches.equals(mycloneTree.branches);
//            return super.equals(obj);
        }

        @Override
        public String toString() {
            return "Tree{" +
                    "name='" + getName() + '\'' +
                    ", branches=" + Arrays.toString(branches) +
                    '}';
        }
    }

}
/*
public class Solution {
    public static void main(String[] args) {
        Tree tree = new Tree("willow", new String[]{"s1", "s2", "s3", "s4"});
        Tree clone = null;
        try {
            clone = tree.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        System.out.println(tree);
        System.out.println(clone);

        System.out.println(tree.branches);
        System.out.println(clone.branches);
    }

    public static class Plant {
        private String name;

        public Plant(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public static class Tree extends Plant {
        private String[] branches;

        public Tree(String name, String[] branches) {
            super(name);
            this.branches = branches;
        }

        public String[] getBranches() {
            return branches;
        }
    }
}


-----------------------------
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
 */