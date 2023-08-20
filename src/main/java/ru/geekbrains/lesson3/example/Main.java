package ru.geekbrains.lesson3.example;

public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addFirst(1);
        list.addFirst(2);
        System.out.println(list);
        list.addFirst(3);
        list.addFirst(4);
        System.out.println(list);
        list.addLast(8);
        list.addLast(5);
        System.out.println(list);
        list.deleteFirst();
        System.out.println(list);
        System.out.println(list);

    }
}

