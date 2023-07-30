package com.example;

import java.util.LinkedList;

public class PathNode {

    private PathNode previousPerson;
    private Person person;

    public PathNode(Person person, PathNode previousPerson){
        this.person = person;
        this.previousPerson = previousPerson;
    }

    public LinkedList<Person> reduce(boolean forward){
        LinkedList<Person> list = new LinkedList<>();
        PathNode node = this;

        while(node != null){

            if(forward){
                list.addFirst(node.getPerson());
            }else{
                list.addLast(node.getPerson());
            }
            node = node.previousPerson;
        }

        return list;
    }

    public void setPerson(Person person){
        this.person = person;
    }

    public void setPreviousPerson(PathNode previousPerson){
        this.previousPerson = previousPerson;
    }

    public Person getPerson(){
        return this.person;
    }

    public PathNode getPreviousPerson(){
        return this.previousPerson;
    }

    @Override
    public String toString() {
        return "PathNode{"+
                person +
                '}';
    }
}
