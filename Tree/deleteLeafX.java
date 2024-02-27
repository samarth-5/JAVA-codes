import java.util.*;
public class deleteLeafX 
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
    public static Node deleteX(Node root,int n)
    {
        if (root == null)
        return null;
        if (root.data == n && root.left == null && root.right == null) 
        return null;
        root.left = deleteX(root.left, n);
        root.right = deleteX(root.right, n);
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
        Node root=new Node(1);          //       1                   1   
        root.left=new Node(3);          //      / \                 /    
        root.right=new Node(3);         //     3   3       ->      3             
        root.left.left=new Node(4);     //    / \                 /     
        root.left.right=new Node(3);    //   4  3                4    
        int n=3;
        preOrder(root);
        System.out.println();
        deleteX(root,n);
        preOrder(root);
    }    
}
