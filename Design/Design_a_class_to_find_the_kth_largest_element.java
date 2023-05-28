//Design a class to find the kth largest element in a stream. 
//Note that it is the kth largest element in the sorted order, not the kth distinct element.

class CustomNode{
  int data;
  CustomNode right;
  CustomNode left;

  public CustomNode(int val){
    this.data = val;
  }
}

class KthLargest {

  CustomNode root = null;
  int rightSideCount = 0;
  int k;
  int dataCount = 0;

    public KthLargest(int k, int[] nums) {
      this.k = k;
        for(int val : nums){
          CustomNode currentNode = new CustomNode(val);
          if(this.root != null && currentNode.data > root.data)rightSideCount++;
          this.root = addToTree(currentNode, this.root);
          this.dataCount++;
          if(this.dataCount > k){
            this.dataCount--;
            CustomNode currentRoot = this.root;
            this.root = deleteNode(this.root, findMin(this.root));
            if(this.root != currentRoot)this.rightSideCount--;
          }
        }
    }

    public CustomNode addToTree(CustomNode currentNode, CustomNode root){
      if(root == null)return currentNode;
      if(currentNode.data > root.data){
        root.right = addToTree(currentNode, root.right);
      }else{
        root.left = addToTree(currentNode, root.left);
      }

      return root;
    }
    
    public int add(int val) {
      CustomNode newNode = new CustomNode(val);
      this.root = addToTree(newNode, this.root);
      this.dataCount++;
      if(this.dataCount < k)return -1;
      if(newNode.data > root.data)this.rightSideCount++;
      if(this.dataCount > k){
        this.dataCount--;
        System.out.println(findMin(this.root));
        CustomNode currentRoot = root;
        this.root = deleteNode(this.root, findMin(this.root));
        if(currentRoot != root)this.rightSideCount--;
      }

        return findMin(this.root);
    }

    public Pair<Integer, Integer> findKthLarge(CustomNode root, int count, int foundValue){
      if(root == null)return  new Pair(count, foundValue);

      Pair<Integer, Integer> right = findKthLarge(root.right, count, foundValue);
      int rightCount = right.getKey();
      int valueOnRight = right.getValue();
      rightCount++;
      if(rightCount == this.k)return new Pair(rightCount, root.data);
      
     return findKthLarge(root.left, rightCount, valueOnRight);
    }


public CustomNode deleteNode(CustomNode root, int key) {
      if(root == null)return null;
        if(key > root.data){
          root.right = deleteNode(root.right, key);
          return root;
        }else if(key < root.data){
          root.left = deleteNode(root.left, key);
          return root;
        }else{
          if(root.right == null && root.left == null)return null;
          if(root.right != null){
            int min = findMin(root.right);
            root.data = min;
            root.right = deleteNode(root.right, min);
          }else{
            int max = findMax(root.left);
            root.data = max;
            root.left = deleteNode(root.left, max);
          }

          return root;
        }
    }

    public int findMin(CustomNode root){
      while(root.left != null)root = root.left;

      return root.data;
    }
    
    public int findMax(CustomNode root){
      while(root.right != null)root = root.right;

      return root.data;
    }


}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
