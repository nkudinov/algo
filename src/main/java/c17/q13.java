package c17;

public class q13 {
    static class BiNode {
        BiNode left;
        BiNode right;
        int value;

        public BiNode(BiNode left, BiNode right, int value) {
            this.left = left;
            this.right = right;
            this.value = value;
        }
    }
    static class Context{
        BiNode head;
        BiNode tail;
    }
    static public void transform(BiNode node, Context context){
        if (node == null ){
            return;
        }
        transform(node.left, context);
        if (node.left == null & context.head == null){
            context.head = node;
            context.tail = node;
        } else {
       //    node.right = context.tail;
           context.tail.left = node;
           context.tail  = node;
        }
        transform( node.right, context);
    }
    public static void printTree(BiNode node,int level){
        if (node == null){
           return;
        }
        printTree(node.left,level+1);
        for(int i =0; i< level;i++){
            System.out.print("--");
        }
        System.out.println(node.value);
        printTree(node.right,level+1);

    }
    public static void printList(BiNode node){
       while( node!=null){
         System.out.println(node.value);
            node = node.left;
       }
    }
    public static void main(String[] args) {
        BiNode d0 = new BiNode(null,null,0);
        BiNode d1 = new BiNode(d0,null,1);
        BiNode d3 = new BiNode(null,null,3);
        BiNode d2 = new BiNode(d1,d3,2);
        BiNode d6 = new BiNode(null,null,6);
        BiNode d5 = new BiNode(null,d6,5);
        BiNode root = new BiNode(d2,d5,4);
        printTree(root, 0);
        Context ctx = new Context();
        transform(root, ctx);
        printList(ctx.head);
    }
}
