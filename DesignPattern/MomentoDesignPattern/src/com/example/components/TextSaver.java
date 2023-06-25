package com.example.components;

//This is the main class that is responsible for creating new Momento
//And to retrieve the old snapshots using undo method
public class TextSaver {
    private CareTaker careTaker = new CareTaker();
    private String data = "";

    public void setText(String text){
        this.data += text;
    }

    public String getText(){
        return this.data;
    }

    public void save(){
        Momento momento = new Momento(this.data);
        careTaker.saveMomento(momento);
    }

    public void undo(){
        Momento momento = careTaker.undo();
        this.data = momento.getData();
    }

}
