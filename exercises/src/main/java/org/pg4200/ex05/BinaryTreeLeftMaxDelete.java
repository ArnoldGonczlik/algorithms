package org.pg4200.ex05;

import org.pg4200.les05.MyMapBinarySearchTree;

public class BinaryTreeLeftMaxDelete<K extends Comparable<K>, V> extends MyMapBinarySearchTree<K, V> {
    @Override
    protected TreeNode delete(K key, TreeNode subtreeRoot) {

        if (subtreeRoot == null) {
            return null;
        }

        int cmp = key.compareTo(subtreeRoot.key);

        if (cmp < 0) {
            subtreeRoot.left = delete(key, subtreeRoot.left);
            return subtreeRoot;
        }

        if (cmp > 0) {
            subtreeRoot.right = delete(key, subtreeRoot.right);
            return subtreeRoot;
        }

        assert cmp == 0;

        size--;

        if (subtreeRoot.left == null) {
            return subtreeRoot.right;
        }

        if (subtreeRoot.right == null) {
            return subtreeRoot.left;
        }

        /*
            Both children are present
         */
        assert subtreeRoot.left != null && subtreeRoot.right != null;

        TreeNode tmp = subtreeRoot;
        subtreeRoot = tmp.left;
        TreeNode newRight = getMaxRight(subtreeRoot);
        newRight.right = tmp.right;
        subtreeRoot.left = tmp.left.left;

        return subtreeRoot;
    }

    private TreeNode getMaxRight(TreeNode subtreeRoot) {
        if (subtreeRoot.right == null) {
            return subtreeRoot;
        }
        return getMaxRight(subtreeRoot.right);
    }
}
