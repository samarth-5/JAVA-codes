import java.util.*;
public class validateBST 
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
    public static boolean isValid(Node root,Node min,Node max)
    {
        if(root==null)
        return true;
        if(min!=null && root.data<=min.data)
        return false;
        else if(max!=null && root.data>=max.data)
        return false;
        boolean left=isValid(root.left, min, root);
        boolean right=isValid(root.right, root, max);
        return left&&right;
    }
    public static void main(String[] args) 
    {
        int values[]={8,5,3,6,10,11,14};
        Node root=null;
        for(int i=0;i<values.length;i++)
        {
            root=insert(root,values[i]);
        }
        if(isValid(root, null, null))
        System.out.println("Valid BST");
        else
        System.out.println("Invalid BST");
    }
}
