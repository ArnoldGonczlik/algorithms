package org.pg4200.ex03;

import java.util.Comparator;

public class IntegerComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
        if (o1 > o2) {
            return o1;
        }
        return o2;
    }
}
