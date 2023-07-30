package com.example;

import java.util.ArrayList;
import java.util.List;

public class Person {

    private int id;
    List<Integer> friends;

    public Person(int id, List<Integer> friens){
        this.id = id;
        this.friends = friends;
    }

    public Person(int id){
        this.id = id;
    }

    public void setFriends(List<Integer> friendsList){
        this.friends = friendsList;
    }

    public void addFriend(int friendId){
        this.friends.add(friendId);
    }

    public List<Integer> getFriends(){
        return this.friends;
    }

    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return this.id;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                '}';
    }
}
