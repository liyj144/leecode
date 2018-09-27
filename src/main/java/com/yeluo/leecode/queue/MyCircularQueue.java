package com.yeluo.leecode.queue;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yanjie on 2018/9/27.
 */
public class MyCircularQueue {

    private List<Integer> queue;
    private int head;
    private int tail;
    private int size;

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        this.queue = new ArrayList<>(k);
        this.head = -1;
        this.tail = -1;
        this.size = k;
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if(!isFull()) {
            this.queue.add(value);
            if(isEmpty()) {
                this.head++;
            }
            this.tail++;
            this.tail = this.tail % this.size;
            return true;
        }
        return false;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if(!isEmpty()) {
            this.queue.remove(this.head);
            if(this.queue.size() == 0) {
                this.head = -1;
                this.tail = -1;
            } else {
                this.head++;
                this.head = this.head % this.size;
            }
            return true;
        }
        return false;
    }

    /** Get the front item from the queue. */
    public int Front() {
        if(isEmpty()) {
            return -1;
        }
        return this.queue.get(this.head);
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if(isEmpty()) {
            return -1;
        }
        return this.queue.get(this.tail);
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return this.tail == this.head && this.tail == -1;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return this.tail - this.head + 1 == this.size ||
                (this.tail == this.head && this.tail != -1 && this.tail != 1);
    }

    public void print() {
        if(isEmpty()) {
            System.out.println("Empty");
        }else {
            for(int i = 0; i < this.size; i ++) {
                if(this.queue.size() <= i) {
                    System.out.print("null ");
                } else {
                    System.out.print(String.format("%d ", this.queue.get(i)));
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        MyCircularQueue obj = new MyCircularQueue(5);
        obj.enQueue(1);
        obj.print();
        obj.deQueue();
        obj.print();

        obj.enQueue(2);
        obj.enQueue(3);
        obj.enQueue(4);
        obj.enQueue(5);
        obj.print();
        obj.enQueue(6);
        obj.print();
        obj.enQueue(7);
        obj.print();
        obj.deQueue();
        obj.print();
        obj.enQueue(8);
        obj.print();

        int param_3 = obj.Front();
        obj.print();
        int param_4 = obj.Rear();
        obj.print();
        boolean param_5 = obj.isEmpty();
        obj.print();
        boolean param_6 = obj.isFull();
        obj.print();
    }
}
