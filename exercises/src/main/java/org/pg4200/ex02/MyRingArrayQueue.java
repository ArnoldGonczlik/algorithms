package org.pg4200.ex02;

import org.pg4200.les02.queue.MyQueue;

public class MyRingArrayQueue<T> implements MyQueue<T> {

    protected Object[] data;

    int realSize = 0;


    private int head = -1;
    private int tail = -1;


    public MyRingArrayQueue(){
        this(10);
    }

    public MyRingArrayQueue(int capacity){
        data = new Object[capacity];
    }


    @Override
    public void enqueue(T value) {
        realSize++;
        if(isEmpty()){
            head = 0;
            tail = 0;
        } else if(tail < data.length - 1 && !(size() == data.length)){
            //there is space
            tail++;
        } else {
            /*
                we run out of space, where "tail"
                points to the last element in the array.
                What to do?
             */
            if (head == 0) {
                //too many elements... let's just create a new array with double size
                Object[] tmp = new Object[data.length * 2];

                int size = size();

                for (int i = 0; i < size; i++) {
                    tmp[i] = data[i];
                }

                head = 0;
                data = tmp;
                tail = size;
            } else if (head > 0){
                //What happens after a deque when head is moved up?
                //Check if tail is at the end pos, but available space at the start of array, if yes tail=0
                if (tail > head && !(data.length - size() == 0)) {
                    tail = 0;
                //Check if tail is below the head, but still available space in array
                } else if (tail < head && !(data.length - size() == 0)) {
                    tail++;
                //Array is completely full and no space left in end or start of array
                //Now need to realign array to a new bigger array, everything before head to the end of tail in new arr
                } else {
                    Object[] tmp = new Object[data.length * 2];

                    int size = size();

                    //First copy everything from head to end of arr to tmp[0]++
                    int headToLast = data.length - head;
                    for (int i = 0; i < headToLast; i++) {
                        tmp[i] = data[i + head];
                    }
                    //Then copy everything from zero to head - 1 (to right before [head]) to end of tmp[]
                    for (int j = 0; j < head; j++) {
                        tmp[j + headToLast] = data[j];
                    }
                    data = tmp;
                    tail = size;
                    head = 0;
                }
            }
        }
        data[tail] = value;
    }


    @Override
    public T dequeue() {
        realSize--;

        if(isEmpty()){
            throw new RuntimeException("Trying to dequeue empty que");
        }

        T value = (T) data[head];

        if(size() == 1){
            //now it ll be empty
            head = -1;
            tail = -1;
        } else {
            /*
                Removing this line will still make all tests pass, as it
                is not a functional bug: it only impacts performance.
                It is done to avoid "memory leaks" in which we keep unused
                objects that cannot be garbage-collected.
             */
            data[head] = null;
            head++;
        }

        return value;
    }

    @Override
    public T peek() {
        if(isEmpty()){
            throw new RuntimeException();
        }

        return (T) data[head];
    }

    @Override
    public int size() {
        if(head < 0){
            return 0;
        } else if (tail == head) {
            return 1;
        } else if (tail > head) {
            return (tail - head) + 1;
        }  else {
            int size = 0;
            //add size based on all elements after head
            size += (data.length - head);
            //then add all from 0 til tail
            size += tail + 1;

            return size;
        }
    }

}
