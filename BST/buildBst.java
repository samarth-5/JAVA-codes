import java.util.*;
class buildBst
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
    public static void inOrder(Node root)
    {
        if(root==null)
        return;
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }
    public static boolean search(Node root,int k)//O(h)  ->O(height)
    {
        if(root==null)
        return false;
        if(k==root.data)
        return true;
        if(k<root.data)
        {
            return search(root.left, k);
        }
        else
        {
            return search(root.right, k);
        }
    }
    public static void main(String[] args) 
    {
        int values[]={5,1,3,4,2,7};
        Node root=null;                             //         5
        for(int i=0;i<values.length;i++)            //        / \
        {                                           //       1   7
            root=insert(root, values[i]);           //        \
        }                                           //         3    
        inOrder(root);                              //        / \
                                                    //       2   4
        int key=7;
        System.out.println(search(root,key));
    }
}