package ru.geekbrains.homework;

class Node {
    int val;
    Node next;

    public Node(int val) {
        this.val = val;
    }
}

class Answer {

    Node head;

    public void reverse() {
        if (head == null || head.next == null) return;

        Node previous = null;
        Node current = head;
        Node next;

        while (current != null) {
            next = current.next;
            current.next = previous;

            previous = current;
            current = next;
        }
        head = previous;
    }
}

public class Printer {
    public static void main(String[] args) {
        // Создаем связанный список 1 -> 2 -> 3 -> 4
        Node head;
        if (args.length == 0) {
            head = new Node(1);
            head.next = new Node(2);
            head.next.next = new Node(3);
            head.next.next.next = new Node(4);
        } else {
            head = new Node(Integer.parseInt(args[0]));
            head.next = new Node(Integer.parseInt(args[1]));
            head.next.next = new Node(Integer.parseInt(args[2]));
            head.next.next.next = new Node(Integer.parseInt(args[3]));
        }

        // Сохраняем голову списка в поле класса Answer
        Answer ans = new Answer();
        ans.head = head;
        // Инвертируем порядок элементов списка
        ans.reverse();

        // Выводим инвертированный порядок элементов списка
        Node current = ans.head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }
}
