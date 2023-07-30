package com.example;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class BFS {

    LinkedList<PathNode> toBeVisited = new LinkedList<>();
    Map<Integer, PathNode> visited = new HashMap<>();

    public BFS(Person source){
        PathNode pathNode = new PathNode(source, null);
        toBeVisited.add(pathNode);
        this.visited.put(source.getId(), pathNode);
    }

    public LinkedList<PathNode> getToBeVisited(){
        return this.toBeVisited;
    }

    public Map<Integer, PathNode> getVisited(){
        return this.visited;
    }

}
