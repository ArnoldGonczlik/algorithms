package org.pg4200.ex02;

import org.pg4200.les02.list.MyArrayList;

public class MyArrayListResizable<T> extends MyArrayList<T> {

    public MyArrayListResizable(int capacity) {
        super(capacity);
    }

    @Override
    public void add(int index, T value) {
        Object[] data2;
        if (size == data.length) {
            data2 = new Object[size * 2];
            for (int i = 0; i < data.length; i++) {
                data2[i] = data[i];
            }
            data = data2;
        }
        super.add(index, value);
    }
}
