import java.util.*;
class minimumDistanceBetweenNodes
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
    public static Node lca(Node root,int n1,int n2)//O(n) S.C.->0
    {
        if(root==null)
        return root;
        if(root.data==n1 || root.data==n2)
        return root;
        Node leftLca=lca(root.left, n1, n2);
        Node rightLca=lca(root.right, n1, n2);
        //if leftLca=val and rightLca=null
        if(rightLca==null)
        return leftLca;
        //if rightLca=val and leftLca=null
        if(leftLca==null)
        return rightLca;

        return root;
    }
    public static int lcaDist(Node root,int n)
    {
        if(root==null)
        return -1;
        if(root.data==n)
        return 0;
        int leftD=lcaDist(root.left, n);
        int rightD=lcaDist(root.right, n);
        if(leftD==-1 && rightD==-1)
        return -1; 
        else if(leftD==-1)
        return rightD+1;
        else
        return leftD+1;
    }
    public static int minDistance(Node root,int n1,int n2)
    {
        Node lca=lca(root,n1,n2);
        int dist1=lcaDist(lca,n1);
        int dist2=lcaDist(lca,n2);
        return dist1+dist2;
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
        int n1=4,n2=5;
        System.out.println(minDistance(root, n1, n2));
    }  
}