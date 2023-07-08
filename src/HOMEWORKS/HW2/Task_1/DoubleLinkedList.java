package HOMEWORKS.HW2.Task_1;

public class DoubleLinkedList {
    Node tail;
    Node head;

    public static class Node {
        int value;
        Node next;
        Node previous;
    }

    public Node find(int value) {
        Node current = head;
        while (current != null) {
            if (current.value == value) return current;
            current = current.next;
        }
        return null;
    }

    public void add(int value) {
        Node newNode = new Node();
        newNode.value = value;
        if (head == null) {
            head = newNode;
        } else {
            newNode.previous = tail;
            tail.next = newNode;
        }
        tail = newNode;
    }

    // Разворот списка
    public void reverse() {
        Node current = tail;
        Node left;
        Node right;
        while (current != null) {
            left = current.previous;
            right = current.next;
            current.previous = right;
            current.next = left;
            current = current.next;
        }
        Node temp = head;
        head = tail;
        tail = temp;
        head.previous = null;
    }

    public void print() {
        Node current = head;
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println();
    }
}
