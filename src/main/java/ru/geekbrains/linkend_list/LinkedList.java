package ru.geekbrains.linkend_list;

public class LinkedList {
    Node head;

    public void sort() {
        if (head == null || head.next == null) {
            return; // Список пуст или содержит только один элемент, сортировать нечего
        }

        boolean flag;
        do {
            flag = false;
            Node current = head;
            Node previous = null;

            while (current.next != null) {
                if (current.value > current.next.value) {
                    Node swap = current.next;
                    current.next = swap.next;
                    swap.next = current;

                    if (previous == null) {
                        head = swap;
                    } else {
                        previous.next = swap;
                    }
                    previous = swap;
                    flag = true;
                } else {
                    previous = current;
                    current = current.next;
                }
            }
        } while (flag);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node current = head;
        sb.append("[ ");
        while (current != null) {
            sb.append(current.value);
            sb.append(", ");

            current = current.next;

        }
        sb.append("]");
        return sb.toString();
    }

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


    public Node find(int value) {
        Node currentNode = head;
        while (currentNode != null) {
            if (currentNode.value == value) {
                return currentNode;
            }
            currentNode = currentNode.next;
        }
        return null;
    }


    public void addFirst(int value) {
        Node node = new Node();
        node.value = value;
        node.next = head;
        head = node;
    }

    public void addLast(int value) {
        Node node = new Node();
        node.value = value;
        node.next = null;
        if (head == null) {
            head = node;
        }

        Node currentNode = head;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }
        currentNode.next = node;
    }

    public class Node {
        int value;

        Node next;
    }

}
