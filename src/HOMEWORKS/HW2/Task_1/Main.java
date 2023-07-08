package HOMEWORKS.HW2.Task_1;

//Необходимо реализовать метод разворота связного списка (двухсвязного или односвязного на выбор).

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        DoubleLinkedList list = new DoubleLinkedList();
        randomList(list, 7, 0, 13);
        list.print();
        list.reverse();
        list.print();
    }

    public static void randomList(DoubleLinkedList list, int len, int min, int max) {
        Random rd = new Random();
        for (int i = 0; i < len; i++) {
            list.add(rd.nextInt(min, max + 1));
        }
    }
}
