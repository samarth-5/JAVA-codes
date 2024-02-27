import java.util.*;
public class sumTree 
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
    public static int sum(Node root)//O(n)
    {
        if(root==null)
        return 0;
        int leftSum=sum(root.left);
        int rightSum=sum(root.right);
        int d=root.data;
        int newLeft=(root.left==null)?0:root.left.data;
        int newRight=(root.right==null)?0:root.right.data;
        root.data=newLeft+leftSum+newRight+rightSum;
        return d;
    }
    public static void preOrder(Node root)
    {
        if(root==null)
        return;
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }
    public static void main(String[] args) 
    {
        Node root=new Node(1);          //       1             Ans:        27
        root.left=new Node(2);          //      / \                       /  \
        root.right=new Node(3);         //     2   3                     9   13
        root.left.left=new Node(4);     //    / \ / \                   / \  / \
        root.left.right=new Node(5);    //   4  5 6 7                  0  0 0  0
        root.right.left=new Node(6);   
        root.right.right=new Node(7);
        sum(root);
        preOrder(root);
    }
}