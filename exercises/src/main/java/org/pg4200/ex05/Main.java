package org.pg4200.ex05;

public class Main {
    public static void main(String[] args) {
        Binarytree myFirstTree = new Binarytree();

        myFirstTree.putValue(10);

        System.out.println(myFirstTree.root.value);

    }

    public boolean sameFirstLast(int[] nums) {
        int size = nums.length;
        if (size > 0 && nums[size - 1] == nums[0]) {
            return true;
        }

        return false;
    }
}


