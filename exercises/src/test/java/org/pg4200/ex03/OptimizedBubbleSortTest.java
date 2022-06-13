package org.pg4200.ex03;

import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OptimizedBubbleSortTest {

    private OptimizedBubbleSort sorter = new OptimizedBubbleSort();

    private class StringComparator implements Comparator<String> {

        @Override
        public int compare(String s1, String s2) {
            return s1.compareTo(s2);
        }
    }

    @Test
    public void sortAlreadySortedNoOptimize() {

        String[] array = {"a", "b", "c", "d"};
        int comparisons = sorter.sort(array, new StringComparator(), false);
        System.out.println(comparisons);

        assertEquals("a", array[0]);
        assertEquals("b", array[1]);
        assertEquals("c", array[2]);
        assertEquals("d", array[3]);

    }

    @Test
    public void sortNoOptimize() {

        String[] array = {"c", "b", "a", "d", "e", "f"};

        int comparisons = sorter.sort(array, new StringComparator(), false);
        System.out.println(comparisons);

        assertEquals("a", array[0]);
        assertEquals("b", array[1]);
        assertEquals("c", array[2]);
        assertEquals("d", array[3]);
        assertEquals("e", array[4]);
        assertEquals("f", array[5]);

    }

    @Test
    public void sortAlreadySortedOptimize() {

        String[] array = {"a", "b", "c", "d"};

        int comparisons = sorter.sort(array, new StringComparator(), true);
        System.out.println(comparisons);

        assertEquals("a", array[0]);
        assertEquals("b", array[1]);
        assertEquals("c", array[2]);
        assertEquals("d", array[3]);
    }

    @Test
    public void sortOptimize() {

        String[] array = {"c", "b", "a", "d", "e", "f"};

        int comparisons = sorter.sort(array, new StringComparator(), true);
        System.out.println(comparisons);

        assertEquals("a", array[0]);
        assertEquals("b", array[1]);
        assertEquals("c", array[2]);
        assertEquals("d", array[3]);
        assertEquals("e", array[4]);
        assertEquals("f", array[5]);

    }

}
