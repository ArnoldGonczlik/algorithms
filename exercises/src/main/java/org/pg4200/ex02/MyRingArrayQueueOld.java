package org.pg4200.ex02;

import org.pg4200.les02.queue.MyQueue;

public class MyRingArrayQueueOld<T> implements MyQueue<T> {

    protected Object[] data;


    private int head = -1;
    private int tail = -1;
    private int oldTail = 0;



    public MyRingArrayQueueOld(){
        this(10);
    }

    public MyRingArrayQueueOld(int capacity){
        data = new Object[capacity];
    }


    @Override
    public void enqueue(T value) {
        if(isEmpty()){
            head = 0;
            tail = 0;
        } else if((oldTail + tail) < data.length - 1){
            //there is space
            tail++;
        } else {
            /*
                we run out of space, where "tail"
                points to the last element in the array.
                What to do?
                Here we consider 2 options, based on the
                position of "head".
             */
            if(head > 0 && tail == data.length - 1){
                oldTail = tail;
                tail = 0;
            } else if (head > 0 && tail >= 0 && tail < head) {
                tail++;
            } else {
                //too many elements... let's just create a new array with double size
                Object[] tmp = new Object[data.length * 2];

                //Gotta change this to add the array from after dequeue to the start, and what replaced null before head to the end of first que.
                if (head > 0) {
                    int howManyFromDequeToEnd = oldTail - head;
                    for (int i = 0; i < howManyFromDequeToEnd; i++) {
                        tmp[i] = data[i + head];
                    }

                    for(int i=0; i<tail; i++){
                        tmp[i+howManyFromDequeToEnd] = data[i];
                    }
                } else {
                    int size = size();
                    for (int i = 0; i < size; i++) {
                        tmp[i] = data[i + head];
                    }
                }

                int size = size();
                head = 0;
                tail = size;
                data = tmp;
            }
        }

        data[tail] = value;
    }


    @Override
    public T dequeue() {

        if(isEmpty()){
            throw new RuntimeException();
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
        }

        return ((tail + oldTail) - head ) + 1;
    }

}
