import java.util.*;
public class printRange 
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
    public static void range(Node root,int k1,int k2)
    {
        if(root==null)
        return;
        if(k1<=root.data && k2<=root.data)
        {
            range(root.left,k1,k2);
        }
        else if(k1>=root.data && k2>=root.data)
        {
            range(root.right, k1, k2);
        }
        else if(k1<=root.data && k2>=root.data)
        {
            System.out.print(root.data+" ");
            range(root.left,k1,k2);
            range(root.right, k1, k2);
        }

    }
    public static void main(String[] args) 
    {
        int values[]={8,5,3,1,4,6,10,11,14};
        Node root=null;
        for(int i=0;i<values.length;i++)
        root=insert(root,values[i]);    
        int k1=1,k2=11;
        range(root,k1,k2);            
    }
}