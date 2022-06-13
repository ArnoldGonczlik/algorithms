package org.pg4200.ex05;

import org.pg4200.les05.MyMapBinarySearchTree;
import org.pg4200.les05.MyMapTreeBased;

import java.util.Objects;

public class TernaryTreeMap<K extends Comparable<K>, V> implements MyMapTreeBased<K, V> {

    protected class TreeNode {
        public K key1;
        public K key2;
        public V value1;
        public V value2;


        public TreeNode left;

        public TreeNode middle;

        public TreeNode right;
    }

    protected TreeNode root;

    protected int size;

    @Override
    public void put(K key, V value) {
        Objects.requireNonNull(key);
        root = put(key, value, root);
    }

    public TreeNode put(K key, V value, TreeNode subtree) {
        //If first node completely empty, no reference to anything
        if (subtree == null) {
            TreeNode node = new TreeNode();
            node.key1 = key;
            node.value1 = value;
            size++;
            return node;
        }

        //If key is bigger than key1 and right node empty (insert to right node)
        if(key.compareTo(subtree.key1) > 0 && subtree.key2 == null) {
            subtree.key2 = key;
            subtree.value2 = value;
            size++;
            return subtree;
        }

        if (key.compareTo(subtree.key1) == 0) {
            subtree.key1 = key;
            subtree.value1 = value;
            size++;
            return subtree;
        }

        if (key.compareTo(subtree.key2) == 0) {
            subtree.key2 = key;
            subtree.value2 = value;
            size++;
            return subtree;
        }

        //Removed code for comment below
        //If key is bigger than key1 and key2 not empty (insert to a subtree, but check if to left, mid or right)

        //If key is smaller than left key1 insert to left
        if(key.compareTo(subtree.key1) < 0) {
            TreeNode node = new TreeNode();
            node.key1 = key;
            node.value1 = value;
            subtree.left = node;
            size++;
            return node;
        }

        //Key is bigger than key1 and smaller than key2, insert to middle
        if(key.compareTo(subtree.key1) > 0 && key.compareTo(subtree.key2) < 0) {
            TreeNode node = new TreeNode();
            node.key1 = key;
            node.value1 = value;
            subtree.middle = node;
            size++;
            return node;
        }

        //Key is bigger than key2, insert to right
        if(key.compareTo(subtree.key2) > 0) {
            TreeNode node = new TreeNode();
            node.key1 = key;
            node.value1 = value;
            subtree.right = node;
            size++;
            return node;
        }

        System.out.println("I should never print");
        size++;
        return new TreeNode();
    }

    @Override
    public void delete(Comparable key) {

    }

    @Override
    public Object get(Comparable key) {
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int getMaxTreeDepth() {
        return 0;
    }
}
