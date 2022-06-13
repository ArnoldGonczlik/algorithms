package org.pg4200.ex03;

import java.util.Comparator;

public class OptimizedBubbleSort {

    public <T> int sort(T[] array, Comparator<T> comparator, boolean optimized) {
        T temp;
        int counter = 0;

        if (optimized) {

            boolean swap = true;
            while (swap) {
                swap = false;
                for (int i = 0; i < array.length - 1; i++) {
                    counter++;
                    if(comparator.compare(array[i], array[i+1]) > 0) {
                        temp = array[i+1];
                        array[i+1] = array[i];
                        array[i] = temp;
                        swap = true;
                    }
                }
            }

        } else {

            //Do naive bubble sort
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array.length; j++) {
                    counter++;
                    if(comparator.compare(array[i], array[j]) < 0) {
                        temp = array[j];
                        array[j] = array[i];
                        array[i] = temp;
                    }
                }
            }
        }

        return counter;
    }
}
