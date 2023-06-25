package com.example.components;


//Momento is class to store the current snap shot of the system
//In this application we are using to store the snap shot of the text when save() is called
public class Momento {
    String data;

    public Momento(String data){
        this.data = data;
    }

    public String getData(){
        return this.data;
    }
}
