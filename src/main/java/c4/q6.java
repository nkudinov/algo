package c4;

public class q6 {
    public Tree leftMostChild(Tree root){
        if (root == null){
            return null;
        }
        while(root.left!=null){
            root = root.left;
        }
        return root;
    }
    public Tree inorderSucc(Tree n){
        if (n == null){
            return null;
        }
        if (n.right !=null){
            return leftMostChild(n.right);
        } else {
            Tree q =n;
            Tree x = q.parent;
            while (x!=null && x.left != q){
                q = x;
                x = q.parent;

            }
            return x;
        }

    }
}
