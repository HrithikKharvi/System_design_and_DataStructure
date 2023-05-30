//when add is called hash the value and place inside the array of linkedlist
// to avoid hash collision we use linkedlist at each index
class MyHashSet {

    List<LinkedList<Integer>> hashList = new ArrayList<>();
    int hashListSize = 10;

    public MyHashSet() {
      for(int i=0; i< hashListSize; i++){
        hashList.add(new LinkedList<>());
      }
    }

    public int generateHashcode(int value){
      return (value % this.hashListSize);
    }

    public void findAndAddToSet(int hashIndex, int value){
      LinkedList<Integer> listToAddKey = this.hashList.get(hashIndex);
      if(!containsKeyInLinkedList(value, listToAddKey)){
        listToAddKey.add(value);
      }
    }

    public boolean containsKeyInLinkedList(int value, LinkedList<Integer> linkedList){
      Iterator<Integer> iterator = linkedList.iterator();
      while(iterator.hasNext()){
        if(value == iterator.next())return true;
      }

      return false;
    }

    public void add(int key) {
        int hashIndex = generateHashcode(key);
        findAndAddToSet(hashIndex, key);
    }

    public int getIndexToDelete(LinkedList<Integer> list, int value){
      Iterator<Integer> iterator = list.iterator();
      int index = 0;

      while(iterator.hasNext()){
        if(iterator.next() == value)return index;
        index++;
      }

      return -1;
    }
    
    public void remove(int key) {
        int hashIndex = generateHashcode(key);
        LinkedList<Integer> listToDeleteKey = this.hashList.get(hashIndex);
        int indexToDeleteValue = getIndexToDelete(listToDeleteKey, key);
        if(indexToDeleteValue != -1){
          listToDeleteKey.remove(indexToDeleteValue);
        }
    }
    
    public boolean contains(int key) {
        int hashIndex = generateHashcode(key);
        LinkedList<Integer> listToCheckValue = this.hashList.get(hashIndex);
        return containsKeyInLinkedList(key, listToCheckValue);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
