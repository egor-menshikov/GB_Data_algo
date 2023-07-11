package HOMEWORKS.HW3_Final;

public class TreeRedBlack {
    Node root;

    public boolean add(int value) {
        if (root == null) {
            root = new Node(value);
            root.color = Color.black;
            return true;
        }
        return addNode(root, value) != null;
    }

    private Node addNode(Node node, int value) {
        if (node.value == value)
            return null;
        if (node.value > value) {
            if (node.left == null) {
                node.left = new Node(value);
                return node.left;
            } else
                return addNode(node.left, value);
        } else {
            if (node.right == null) {
                node.right = new Node(value);
                return node.right;
            } else
                return addNode(node.right, value);
        }
    }

    public boolean contains(int value) {
        Node currentNode = root;
        while (currentNode != null) {
            if (currentNode.value == value)
                return true;
            if (currentNode.value > value)
                currentNode = currentNode.left;
            else
                currentNode = currentNode.right;
        }
        return false;
    }

    private class Node {
        int value;
        Node left;
        Node right;
        Color color;

        Node() {
            this.color = Color.red;
        }

        Node(int value) {
            this.value = value;
            this.color = Color.red;
        }
    }

    enum Color {red, black}
}
