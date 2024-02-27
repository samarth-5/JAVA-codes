import java.util.*;
public class sizeOfLargestBst 
{
    static class Node
    {
        int data;
        Node left;
        Node right;
        public Node(int d)
        {
            this.data=d;
            this.left=null;
            this.right=null;
        }
    }    
    static class Info
    {
        boolean isBST;
        int size;
        int min;
        int max;
        public Info(boolean isBST,int size,int min,int max)
        {
            this.isBST=isBST;
            this.size=size;
            this.max=max;
            this.min=min;
        }
    }
    public static int maxBST=0;
    public static Info largestBST(Node root)
    {
        if(root==null)
        return new Info(true,0,Integer.MAX_VALUE,Integer.MIN_VALUE);
        Info left=largestBST(root.left);
        Info right=largestBST(root.right);
        int size=left.size+right.size+1;
        int min=Math.min(root.data,Math.min(left.min,right.min));
        int max=Math.max(root.data,Math.max(left.max,right.max));

        if(root.data<=left.max || root.data>=right.min)
        return new Info(false,size,min,max);
        if(left.isBST && right.isBST)
        {
            maxBST=Math.max(maxBST,size);
            return new Info(true,size,min,max);
        }
        return new Info(false,size,min,max);
    }
    public static void main(String[] args) 
    {
        Node root=new Node(50);               //       50                           
        root.left=new Node(30);               //      /  \            Ans.     60
        root.left.left=new Node(5);           //    30   60                   / \
        root.left.right=new Node(20);         //   / \  /  \                45  70
        root.right=new Node(60);              //  5 20 45  70                  / \
        root.right.left=new Node(45);         //          / \                 65  80
        root.right.right=new Node(70);        //         65 80                Size=5
        root.right.right.left=new Node(65);
        root.right.right.right=new Node(80);
        Info info=largestBST(root);
        System.out.println("Largest BST Size:"+maxBST);
    }
}
