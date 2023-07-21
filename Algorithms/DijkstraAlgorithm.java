class Pair{
    int first;
    int second;
    
    public Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}

class Solution
{
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    
    //will have a priority queue which stores the distance and the node
    //we get the each node and see all its neighbours and check what is the cost of going to that node
    //If the coast is less than the previously stored one we replace and we take that node and distance 
    //into the consideration of next iteration using the queue
    //we use normal array of length of number of nodes
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.first - y.first);
        int[] distanceArray = new int[V];
        
        for(int i=0; i< V; i++)distanceArray[i] = Integer.MAX_VALUE;
        
        distanceArray[S] = 0;
        pq.add(new Pair(0, S));
        
        while(pq.size() > 0){
            int distance = pq.peek().first;
            int node = pq.peek().second;
            
            pq.remove();
            
            ArrayList<ArrayList<Integer>> adjs = adj.get(node);
            
            for(ArrayList<Integer> edge : adjs){
                int edgeNode = edge.get(0);
                int edgeWeight = edge.get(1);
                
                int calculatedWeight = distance + edgeWeight;
                
                if(calculatedWeight < distanceArray[edgeNode]){
                    distanceArray[edgeNode] = calculatedWeight;
                    pq.add(new Pair(calculatedWeight, edgeNode));
                }
            }
        }
        
        return distanceArray;
        
    }
}
