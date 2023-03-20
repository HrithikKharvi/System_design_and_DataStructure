class StackNode{
  public int data;
  public StackNode next;

  public StackNode(int data){
    this.data = data;
  }
}

class MyStack{
  public StackNode top;
  public void push(int val){
    StackNode t = new StackNode(val);
    t.next = top;
    top = t;
  }

  public void pop(){
    if(top == null)return;
    top = top.next;
  }

  public StackNode peek(){
    return top;
  }

}


class MinStack extends MyStack{
    public MyStack s2;

    public MinStack() {
      s2 = new MyStack();
    }
    
    public void push(int val) {
        if(s2.top != null){
          s2.push(Math.min(s2.top.data, val));
        }else{
          s2.push(val);
        }

        super.push(val);
    }
    
    public void pop() {
      if(s2 == null)return;
      s2.pop();
      super.pop();
    }
    
    public int top() {
        return super.top.data;
    }
    
    public int getMin() {
        return s2.top.data;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
