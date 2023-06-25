package com.example.components;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

//This class will handle the snapshots of the text at different point of time when save is clicked
public class CareTaker {

    private Stack<Momento> history = new Stack<>();

    public void saveMomento(Momento momento){
        this.history.push(momento);
    }

    public Momento undo(){
        return this.history.pop();
    }

}
