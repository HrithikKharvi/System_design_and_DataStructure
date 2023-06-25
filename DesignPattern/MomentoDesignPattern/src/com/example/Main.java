package com.example;

import com.example.components.TextSaver;

public class Main {

    public static void main(String[] args) {

        TextSaver ts = new TextSaver();
        ts.setText("Hello world!");
        ts.save();
        ts.setText(",Welcome to Java world!");
        System.out.println(ts.getText());
        ts.undo();
        System.out.println(ts.getText());
    }
}
