package f;

public class q22 {
    static class Node {
        int data;
        Node left;
        Node right;
        Node() {
            this.data = 0;
            this.left = null;
            this.right = null;
        }
        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    int visibleNodes(Node root,int maxLevel){
        if (root == null){
            return maxLevel;
        }
        return Math.max( visibleNodes(root.left,maxLevel+1), visibleNodes(root.right,maxLevel+1));
    }
    int visibleNodes(Node root) {
         return visibleNodes(root,0);

    }
    public static void main(String[] args) {

    }
}
