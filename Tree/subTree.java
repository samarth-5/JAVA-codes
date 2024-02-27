import java.util.*;
class subTree
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
    public static boolean isIdentical(Node root,Node subRoot)
    {
        if(root==null && subRoot==null)
        return true;
        else if(root==null || subRoot==null)
        return false;
        if(root.data != subRoot.data)
        return false;
        if(!isIdentical(root.left,subRoot.left))
        return false;
        if(!isIdentical(root.right,subRoot.right))
        return false;
        return true;
    }
    public static boolean subTreeExist(Node root,Node subRoot)
    {
        if(root==null || subRoot==null)
        return false;
        if(root.data==subRoot.data)
        {
            if(isIdentical(root,subRoot))
            return true;
        }
        //boolean left=subTreeExist(root.left, subRoot);
        //boolean right=subTreeExist(root.right, subRoot);
        //return left||right;
        return subTreeExist(root.left, subRoot) || subTreeExist(root.right, subRoot);
    }
    public static void main(String[] args) {
        Node root=new Node(1);
        root.left=new Node(2);
        root.right=new Node(3);
        root.left.left=new Node(4);
        root.left.right=new Node(5);
        root.right.right=new Node(6);
        Node subRoot=new Node(2);
        subRoot.left=new Node(4);
        subRoot.right=new Node(6);
        System.out.println(subTreeExist(root, subRoot));
    }
}