package com.example;

public class MyArrayList {

    private int[] arr;
    private int top = 0;

    public MyArrayList(){
        arr = new int[10];
    }

    public void add(int value){
        if(top == arr.length){
            int[] newArr = new int[arr.length*2];
            for(int i=0; i< arr.length; i++){
                newArr[i] = arr[i];
            }
            arr = newArr;
        }
        arr[top++] = value;
    }

    public int get(int index){
        if(index < 0 || index >= arr.length)return -1;
        return arr[index];
    }

    public int remove(int index){
        if(index < 0 || index >= arr.length)return -1;
        int removedElement = arr[index];
        for(int i=index+1; i< arr.length; i++){
            arr[i-1] = arr[i];
        }
        top--;
        return removedElement;
    }

    public boolean isEmpty(){
        return top == 0 ? true : false;
    }

    @Override
    public String toString(){
        String result = "{";

        for(int i=0; i< top; i++){
            if(i == top-1)result += arr[i];
            else result += arr[i] + ",";
        }
        result += "}";

        return result;
    }

}
