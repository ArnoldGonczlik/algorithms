package org.pg4200.ex05;

public class Binarytree {

    Node root;
    int size = 0;


    protected static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node (int value) {
            this.value = value;
        }

    }

    public void putValue (int value) {
        if (size == 0) {
            root = new Node(value);
        } else {
            if (value > root.value) {
                root.right = new Node(value);
            } else {
                root.left = new Node(value);
            }
        }
        size++;
    }


}
