package HOMEWORKS.HW3_Final;

public class Main {
    public static void main(String[] args) {
        TreeRedBlack tree = new TreeRedBlack();
        tree.add(5);
        tree.add(1);
        tree.add(5);
        tree.add(7);
        System.out.println(tree.contains(7));
    }
}
