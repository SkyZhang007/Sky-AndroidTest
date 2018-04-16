package com.sky.androidtest.java;

/**
 * Created by yuetu-develop on 2018/4/10.
 */

public class QueueTest {

    public Node<Integer> head;
    public Node<Integer> current;

    public void addNode(int data){
        if(head == null){
            head = new Node<>(data);
            current = head;
        } else {
            current = new Node<>(data);
        }
    }


    class Node<E>{
        Node<E> pre;
        E data;
        public Node(E data){
            this.data = data;
        }
    }

}
