import java.util.*;
public class deleteNodeInBst 
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
    public static Node insert(Node root,int val)
    {
        if(root==null)
        {
            root=new Node(val);
            return root;
        }
        if(root.data>val)
        {
            //insert in left subtree
            root.left=insert(root.left,val);
        }
        else if(root.data<val)
        {
            //insert in roght subtree
            root.right=insert(root.right,val);
        }
        return root;
    }
    public static Node findInorderSuccessor(Node root)
    {
        while(root.left != null)
        {
            root=root.left;
        }
        return root;
    }
    public static Node delete(Node root,int val)
    {
        if(root.data < val)
        root.right=delete(root.right, val);
        else if(root.data > val)
        root.left=delete(root.left, val);
        else
        {
            //case 1-leaf node
            if(root.left==null && root.right == null)
            {
                return null;
            } 
            //case 2-single child
            if(root.left == null)
            return root.right;
            else if(root.right == null)
            return root.left;
            //case 3-both children->finding inorder successor
            Node is=findInorderSuccessor(root.right);//is=leftmost node in right subtree
            root.data=is.data;
            root.right=delete(root.right, is.data);
        }
        return root;
    }
    public static void inOrder(Node root)
    {
        if(root==null)
        return;
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }
    public static void main(String[] args) 
    {
        int values[]={8,5,3,1,4,6,10,11,14};         //          8
        Node root=null;                              //         / \
        for(int i=0;i<values.length;i++)             //        5   10
        root=insert(root,values[i]);                 //       / \    \
        inOrder(root);                               //      3   6   11
        System.out.println();                        //     / \       \
        root=delete(root,8);                     //    1   4      14
        System.out.println();
        inOrder(root);
    }
}
