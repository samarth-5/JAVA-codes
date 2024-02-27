import java.util.*;
public class kthAncestorOfNode 
{
    static class Node
    {
        int data;
        Node left,right;
        Node(int d)
        {
            this.data=d;
            this.left=null;
            this.right=null;
        }
    }
    public static int kAncestor(Node root,int n,int k)
    {
        if(root==null)
        return -1;
        if(root.data==n)
        return 0;
        int leftD=kAncestor(root.left, n, k);
        int rightD=kAncestor(root.right, n, k);
        if(leftD==-1 && rightD==-1)
        return -1;
        int max=Math.max(leftD,rightD);
        if(max+1==k)
        System.out.println(root.data);
        return max+1;
    }
    public static void main(String[] args) 
    {
        Node root=new Node(1);          //       1
        root.left=new Node(2);          //      / \
        root.right=new Node(3);         //     2   3
        root.left.left=new Node(4);     //    / \ / \
        root.left.right=new Node(5);    //   4  5 6  7
        root.right.left=new Node(6);   
        root.right.right=new Node(7);
        int n=5,k=2;
        kAncestor(root,n,k);
    }  
}
