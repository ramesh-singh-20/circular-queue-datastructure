package com.alhpacoder.datastructure;

public class CircularQueue {
    private int arr[];
    private int front;
    private int rear;

    public CircularQueue() {
        this.arr = new int[5];
        this.front = -1;
        this.rear = -1;
    }

    public boolean isEmpty() {
        return (this.front == -1 && this.rear == -1);
    }

    public int front() {
        if (this.isEmpty()) {
            throw new UnsupportedOperationException("Queue is empty.");
        }
        return this.arr[front];
    }

    public void enQueue(int data) {
        if (this.isEmpty()) {
            this.front = 0;
            this.rear = 0;
            this.arr[rear] = data;
            return;
        }
        this.rear = (this.rear + 1) % this.arr.length;

        if (this.rear == this.front) {
            throw new UnsupportedOperationException("Cannot add elements as queue is full.");
        }
        this.arr[rear] = data;
    }

    public int deQueue(){
        if(this.isEmpty()){
            throw new UnsupportedOperationException("Cannot remove elements as queue is empty.");
        }
        int temp= this.arr[front];
        if(this.front== this.rear){

            this.front= -1;
            this.rear= -1;
            return temp;
        }
       this.front= (this.front+1)%this.arr.length;

        return temp;
    }


}
