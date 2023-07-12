package HOMEWORKS.HW3_Final;

public class TreeRedBlack {
    private Node root;

    public boolean add(int value) {
        if (root != null) {
            boolean result = addNode(root, value);
            root = rebalance(root);
            root.color = Color.BLACK;
            return result;
        } else {
            root = new Node(value);
            root.color = Color.BLACK;
            return true;
        }
    }

    private boolean addNode(Node node, int value) {
        if (node.value == value)
            return false;
        else {
            if (node.value > value) {
                if (node.left != null) {
                    boolean result = addNode(node.left, value);
                    node.left = rebalance(node.left);
                    return result;
                } else {
                    node.left = new Node(value);
                    return true;
                }
            } else {
                if (node.right != null) {
                    boolean result = addNode(node.right, value);
                    node.right = rebalance(node.right);
                    return result;
                } else {
                    node.right = new Node(value);
                    return true;
                }
            }
        }
    }

    private Node rebalance(Node node) {
        Node result = node;
        boolean needBalance;
        do {
            needBalance = false;
            if (result.right != null && result.right.color == Color.RED &&
                    (result.left == null || result.left.color == Color.BLACK)) {
                needBalance = true;
                result = rightSwap(result);
            }
            if (result.left != null && result.left.color == Color.RED &&
                    result.left.left != null && result.left.left.color == Color.RED) {
                needBalance = true;
                result = leftSwap(result);
            }
            if (result.left != null && result.left.color == Color.RED &&
                    result.right != null && result.right.color == Color.RED) {
                needBalance = true;
                colorSwap(result);
            }
        }
        while (needBalance);
        return result;
    }

    private Node leftSwap(Node node) {
        Node leftChild = node.left;
        Node midChild = leftChild.right;
        leftChild.right = node;
        node.left = midChild;
        leftChild.color = node.color;
        node.color = Color.RED;
        return leftChild;
    }

    private Node rightSwap(Node node) {
        Node rightChild = node.right;
        Node midChild = rightChild.left;
        rightChild.left = node;
        node.right = midChild;
        rightChild.color = node.color;
        node.color = Color.RED;
        return rightChild;
    }

    private void colorSwap(Node node) {
        node.right.color = Color.BLACK;
        node.left.color = Color.BLACK;
        node.color = Color.RED;
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

    public void printInOrder() {
        System.out.println();
        showInOrder(root);
    }

    private void showInOrder(Node node) {
        if (node != null) {
            showInOrder(node.left);
            if (root == node)
                System.out.print("***ROOT*** ");
            System.out.print(node.value + " ");
            System.out.print(node.color + "\n");
            showInOrder(node.right);
        }
    }

    private class Node {
        int value;
        Node left;
        Node right;
        Color color;

        Node() {
            this.color = Color.RED;
        }

        Node(int value) {
            this.value = value;
            this.color = Color.RED;
        }
    }

    private enum Color {RED, BLACK}
}
