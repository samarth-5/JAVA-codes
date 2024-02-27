import java.util.*;
public class rootToLeafPath 
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
    public static void path(Node root,ArrayList<Integer>ar)
    {      
        if(root==null)
        return;  
        ar.add(root.data);
        if(root.left==null && root.right==null)
        {
            System.out.println(ar);
        }
        path(root.left, ar);
        path(root.right, ar);
        ar.remove(ar.size()-1);

    }
    public static void main(String[] args) 
    {
        int values[]={8,5,3,1,4,6,10,11,14};
        Node root=null;
        for(int i=0;i<values.length;i++)
        root=insert(root,values[i]);    
        ArrayList<Integer> ar=new ArrayList<>();
        path(root,ar);            
    }
}
