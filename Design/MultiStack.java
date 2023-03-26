package com.example;


import java.util.ArrayList;
import java.util.Stack;

class Node{
    public int data;
    public Node above, below;

    public Node(int data){
        this.data = data;
    }

}

class MyStack{
    public int capacity;
    public int size = 0;
    public Node top, bottom;

    public MyStack(int capacity){
        this.capacity = capacity;
    }

    public boolean isFull(){
        return this.size == this.capacity;
    }

    public boolean isEmpty(){
        return this.size == 0;
    }

    public void join(Node above, Node below){
        if(above != null)above.below = below;
        if(below != null)below.above = above;
    }

    public void push(int val){
        Node n = new Node(val);
        this.size++;
        if(size == 1)bottom = n;
        join(n, top);
        top = n;
    }

    public int pop() {
        if (isEmpty()) return -1;
        Node t = top;
        size--;
        top = top.below;
        return t.data;
    }

    public int removeBottom(){
        Node s = bottom;
        bottom = bottom.above;
        if(bottom != null)bottom.below = null;
        return s.data;
    }
}

public class MultiStack {
    int capacity;
    ArrayList<MyStack> stacks = new ArrayList<>();

    public MultiStack(int capacity){
        this.capacity = capacity;
    }

    public MyStack getLastStack(){
        return stacks.size() == 0 ? null : stacks.get(stacks.size() - 1);
    }

    public void push(int val){
        MyStack last = getLastStack();
        if(last != null && !last.isFull()){
            last.push(val);
        }else{
            MyStack s = new MyStack(this.capacity);
            s.push(val);
            stacks.add(s);
        }
    }

    public int pop(){
        MyStack last = getLastStack();
        if(last == null)return -1;
        int ele = last.pop();
        if(last.isEmpty())stacks.remove(stacks.size() - 1);
        return ele;
    }


    public int leftShift(int index, boolean removeTop){
        int removedElement;

        MyStack s = stacks.get(index);
        if(removeTop){
            removedElement = s.pop();
        }else{
            removedElement = s.removeBottom();
        }

        if(s.isEmpty()){
            stacks.remove(index);
        }else if(index + 1 < stacks.size()){
            int val = leftShift(index+1, true);
            s.push(val);
        }

        return removedElement;
    }

    public int popAt(int index){
        if(index >= stacks.size())return -1;
        return leftShift(index, true);
    }

}
