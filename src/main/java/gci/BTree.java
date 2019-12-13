package gci;

public class BTree {
    int value;
    BTree left;
    BTree right;

    public BTree(int value) {
        this.value  = value;
        this.left   = null;
        this.right  = null;
    }
    private void add(BTree root, int x){
        if (root.value > x) {
            if (root.left == null){
                root.left = new BTree(x);
            } else {
                add(root.left, x);
            }
        } else {
            if (root.right == null){
                root.right = new BTree(x);
            } else {
                add(root.right, x);
            }
        }
    }
    public void add(int x){
      add(this,x);
    }
    private void print(BTree root){
       if (root==null){
          return;
       }
       print(root.left);
       System.out.println(root.value);
       print(root.right);
    }
    public void print(){
       print(this);
    }

    public static void main(String[] args) {
        BTree root = new BTree(1);
        root.add(2);
        root.add(-1);
        root.add(-2);
        root.add(0);
        root.print();
    }
}
