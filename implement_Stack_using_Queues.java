class MyStack {
    int top = -1;
    Queue<Integer> queue;
    ArrayList<Integer> tempArray;
    public MyStack() {
      queue = new LinkedList<>();
      tempArray = new ArrayList<>();
    }
    
    public void push(int x) {
      if(top == -1){
        this.queue.add(x);
      }else{
        this.tempArray.add(x);
        top++;
      }
    }
    
    public int pop() {
      if(this.top == -1 && queue.size() == 0)return -1;
        if(this.top == -1){
          fill();
          return this.tempArray.remove(top--);
        }else{
          return this.tempArray.remove(top--);
        }
    }
    
    public int top() {
        if(top == -1){
          fill();
        }
          return this.tempArray.get(top);
    }

    public void fill(){
      while(this.queue.size() > 0){
        tempArray.add(queue.remove());
        top++;
      }
    }
    
    public boolean empty() {
        if(this.top == -1 && this.queue.size() == 0)return true;
        return false;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
