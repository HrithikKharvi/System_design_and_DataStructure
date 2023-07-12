class MyNode{
  MyNode[] nodeList = new MyNode[26];
  boolean flag =false;

  public boolean containsKey(char ch){
    return nodeList[ch-'a'] != null;
  }

  public void put(char ch, MyNode node){
    this.nodeList[ch - 'a'] = node;
  }

  public MyNode get(char ch){
    return this.nodeList[ch - 'a'];
  }

  public void setEnd(){
    this.flag = true;
  }

  public boolean isEnd(){
    return this.flag;
  }
}

class Trie {
    MyNode root;

    public Trie() {
        root = new MyNode();
    }
    
    public void insert(String word) {
        MyNode currentNode = this.root;

        for(int i=0; i<word.length(); i++){
          char currentChar = word.charAt(i);
          if(!currentNode.containsKey(currentChar)){
            currentNode.put(currentChar, new MyNode());
          }

          currentNode = currentNode.get(currentChar);
        }

        currentNode.setEnd();
    }
    
    public boolean search(String word) {
        MyNode currentNode = root;

        for(int i=0; i<word.length(); i++){
          char currentChar = word.charAt(i);
          if(!currentNode.containsKey(currentChar))return false;
          currentNode = currentNode.get(currentChar);
        }

        return currentNode.isEnd();
    }
    
    public boolean startsWith(String prefix) {
      MyNode currentNode = root;

      for(int i=0; i<prefix.length(); i++){
        char currentChar = prefix.charAt(i);
        if(!currentNode.containsKey(currentChar))return false;
        currentNode = currentNode.get(currentChar);
      }

      return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 *
