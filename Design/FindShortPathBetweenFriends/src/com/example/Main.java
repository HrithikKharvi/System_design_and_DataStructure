package com.example;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Person per1 = new Person(1);
        Person per2 = new Person(2);
        Person per3 = new Person(3);
        Person per4 = new Person(4);
        Person per5 = new Person(4);

	//Create the LIST for each Person
        List<Integer> personOneList = new ArrayList<>();
        List<Integer> personTwoList = new ArrayList<>();
        List<Integer> personThreeList = new ArrayList<>();
        List<Integer> personFourList = new ArrayList<>();
        List<Integer> personFiveList = new ArrayList<>();

	//add the friend list to each Person
        personOneList.add(4);
        personFourList.add(1);

	// add the list to the corresponding Person
        per1.setFriends(personOneList);
        per2.setFriends(personTwoList);
        per3.setFriends(personThreeList);
        per4.setFriends(personFourList);
        per5.setFriends(personFiveList);

        Map<Integer, Person> people = new HashMap<>();
        people.put(1, per1);
        people.put(2, per2);
        people.put(3, per3);
        people.put(4, per4);
        people.put(5, per5);

        LinkedList<Person> persons = getShortestPath(people, 1, 4);

	//Loop through the result to check the resulted shortest path
        for(Person per : persons){
            System.out.print(per.getId());
            System.out.print("->");
        }

    }

    public static LinkedList<Person> getShortestPath(Map<Integer, Person> people, int source, int dest){

        if(!people.containsKey(source) || !people.containsKey(dest))return new LinkedList<>();

        Person sourcePerson = people.get(source);
        Person destPerson = people.get(dest);

        BFS sourceBFS = new BFS(sourcePerson);
        BFS destBFS = new BFS(destPerson);

        while(!sourceBFS.toBeVisited.isEmpty() || !destBFS.toBeVisited.isEmpty()){
            PathNode collision = checkForCollision(sourceBFS, destBFS, people);

            if(collision != null){
                return merge(collision.getPerson().getId(), sourceBFS, destBFS);
            }

            collision = checkForCollision(destBFS, sourceBFS, people);

            if(collision != null){
                return merge(collision.getPerson().getId(), sourceBFS, destBFS);
            }
        }
        return new LinkedList<>();
    }

    public static LinkedList<Person> merge(int collisionID, BFS sourceBFS, BFS destBFS){
        PathNode sourcePath = sourceBFS.getVisited().get(collisionID);
        PathNode destPath = destBFS.getVisited().get(collisionID);

        LinkedList<Person> sourceList = sourcePath.reduce(true);
        LinkedList<Person> destList = destPath.reduce(false);

        destList.removeFirst();
        sourceList.addAll(destList);

        return sourceList;
    }

    public static PathNode checkForCollision(BFS sourceBFS, BFS destBFS, Map<Integer, Person> people){
        int size = sourceBFS.getToBeVisited().size();
        for(int i = 0; i<size; i++){
            PathNode pathNode = sourceBFS.getToBeVisited().poll();
            if(destBFS.getVisited().containsKey(pathNode.getPerson().getId()))return pathNode;
            List<Integer> friends = pathNode.getPerson().getFriends();

            for(int friendId : friends) {
                if(sourceBFS.getVisited().containsKey(friendId))continue;
                Person friend = people.get(friendId);
                PathNode next = new PathNode(friend, pathNode);
                sourceBFS.getVisited().put(friendId, next);
                sourceBFS.getToBeVisited().add(next);
            }
        }

        return null;
    }
}
