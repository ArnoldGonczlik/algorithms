package org.pg4200.ex03;

public class Main {
    public static void main(String[] args) {
        Integer[] unsortedArray = {5,6,1,2,3,4};

        OptimizedBubbleSort sorter = new OptimizedBubbleSort();

        System.out.println(sorter.sort(unsortedArray, new IntegerComparator(), false));
    }
}
