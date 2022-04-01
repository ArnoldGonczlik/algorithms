package org.pg4200.ex05;

import org.pg4200.les05.MyMapBinarySearchTree;

public class BinaryTreeLeftMaxDelete<K extends Comparable<K>, V> extends MyMapBinarySearchTree<K, V> {

    @Override
    protected TreeNode delete(K key, TreeNode subtreeRoot) {

        if (subtreeRoot == null) {
            /*
                This will happen when the key is not found, and we try a
                recursion on a null node.
                In this case, the new root of a null substree is still a null
                subtree, and we can return itself directly (ie null)
             */
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

        /*
            Here, we are done with the recursion.
            How to delete this node will depend on
            how many children it has
         */
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
        subtreeRoot = max(tmp.left);
        subtreeRoot.left = deleteMax(tmp.left);
        subtreeRoot.right = tmp.right;

        return subtreeRoot;

    }

    private TreeNode max(TreeNode subtreeRoot) {
        if (subtreeRoot.right == null) {
            return subtreeRoot;
        }
        return max(subtreeRoot.right);
    }

    private TreeNode deleteMax(TreeNode subtreeRoot) {
        if (subtreeRoot.right == null) {
            return subtreeRoot.left;
        }

        subtreeRoot.right = deleteMax(subtreeRoot.right);

        return subtreeRoot;
    }

}
