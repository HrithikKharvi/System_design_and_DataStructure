class MyHashMap {

    private LinkedList<Pair<Integer,Integer>>[] map;

    public MyHashMap() {
        this.map = new LinkedList[10];
        for(int i=0;i<10; i++){
          this.map[i] = new LinkedList<>();
        }
    }

    //custom private methods ================ 

      private int hash(int key){
        return key % 10;
      }

      private int getKeyIndex(LinkedList<Pair<Integer, Integer>> list, int key){
        int index = 0;
        for(Pair<Integer, Integer> pair : list){
          if(pair.getKey() == key)return index;
          index++;
        }

        return -1;
      }

    //=======================================

    
    public void put(int key, int value) {
        int hashIndex = hash(key);
        LinkedList<Pair<Integer, Integer>> list = this.map[hashIndex];

        int keyIndex = getKeyIndex(list, key);

        if(keyIndex == -1){
          list.add(new Pair(key, value));
        }else{
          remove(key);
          list.add(new Pair(key, value));
        }
    }
    
    public int get(int key) {
        int hashIndex = hash(key);
        LinkedList<Pair<Integer, Integer>> list = this.map[hashIndex];
        int index = getKeyIndex(list, key);
        int count = 0;
        for(Pair<Integer, Integer> pair : list){
          if(index == count)return pair.getValue();
          count++;
        }
        return -1;
    }
    
    public void remove(int key) {
        int hashIndex = hash(key);
        LinkedList<Pair<Integer, Integer>> list = this.map[hashIndex];
        int index = getKeyIndex(list, key);

        if(index == -1)return;
        list.remove(index);
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */