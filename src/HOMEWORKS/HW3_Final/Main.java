package HOMEWORKS.HW3_Final;

//Необходимо превратить собранное на семинаре дерево поиска в полноценное левостороннее красно-черное дерево.
//И реализовать в нем метод добавления новых элементов с балансировкой.

public class Main {
    public static void main(String[] args) {
        TreeRedBlack tree = new TreeRedBlack();

        tree.add(5);
        tree.printInOrder();

        tree.add(7);
        tree.printInOrder();

        tree.add(-1);
        tree.add(-14);
        tree.add(9);
        tree.add(-10);
        tree.add(0);
        tree.add(3);
        tree.printInOrder();

        System.out.println();
        System.out.println(tree.contains(-1));
        System.out.println(tree.contains(88));
    }
}
