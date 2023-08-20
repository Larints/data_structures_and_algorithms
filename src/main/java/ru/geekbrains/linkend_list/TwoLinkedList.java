package ru.geekbrains.linkend_list;

public class TwoLinkedList {

    private Node head;

    private Node tail;

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


    public void add(int value) {
        Node node = new Node();
        node.value = value;
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            node.previous = tail;
            tail = node;
        }
    }

    public void delete(Node node) {
        Node previous = node.previous;
        Node next = node.next;
        if (previous == null) {
            next.previous = null;
            head = next;
        } else {
            if (next == null) {
                previous.next = null;
                tail = previous;
            } else {
                previous.next = next;
                next.previous = previous;
            }
        }

    }


    public void reverse() {
        Node currentNode = head;
        while (currentNode != null) {
            Node next = currentNode.next;
            Node previous = currentNode.previous;
            currentNode.next = previous;
            currentNode.previous = next;
            if (previous == null) {
                tail = currentNode;
            }
            if (next == null) {
                head = currentNode;
            }
            currentNode = next;
        }
    }


    public void add(int value, Node node) {
        Node next = node.next;
        Node newNode = new Node();
        newNode.value = value;
        node.next = newNode;
        newNode.previous = node;
        if (next == null) {
            tail = newNode;
        } else {
            next.previous = newNode;
            newNode.next = next;
        }
    }

    public Node find(int value) {
        Node curentNode = head;
        while (curentNode != null) {
            if (curentNode.value == value) {
                return curentNode;
            }
            curentNode = curentNode.next;
        }
        return null;
    }


    public class Node {
        int value;

        Node next;

        Node previous;
    }

}
