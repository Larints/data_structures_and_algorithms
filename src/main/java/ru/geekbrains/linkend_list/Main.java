package ru.geekbrains.linkend_list;

public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addLast(4);
        System.out.println(list);
        list.reverse();
        System.out.println(list);
        System.out.println(list.find(4));
        list.sort();
        System.out.println(list);

        TwoLinkedList list2 = new TwoLinkedList();
        list2.add(1);
        list2.add(3);
        list2.add(7);
        System.out.println(list2);
        list2.reverse();
        System.out.println(list2);
    }
}
