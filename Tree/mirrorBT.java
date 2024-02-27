import java.util.*;
public class mirrorBT 
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
    public static Node mirror(Node root)
    {
        if(root==null)
        return null;
        Node left=mirror(root.left);
        Node right=mirror(root.right);
        root.left=right;
        root.right=left;
        return root;
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
        Node root=new Node(1);          //       1             Mirror:       1
        root.left=new Node(2);          //      / \                         / \
        root.right=new Node(3);         //     2   3                       3   2
        root.left.left=new Node(4);     //    / \ / \                     / \ / \
        root.left.right=new Node(5);    //   4  5 6 7                    7  6 5  4 
        root.right.left=new Node(6);   
        root.right.right=new Node(7);
        preOrder(root);
        System.out.println();
        mirror(root);
        preOrder(root);
    }
}
