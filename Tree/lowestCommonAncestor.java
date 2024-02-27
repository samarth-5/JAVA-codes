import java.util.*;
public class lowestCommonAncestor 
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
    //Approach 1  
    //public static boolean getPath(Node root,int n,ArrayList<Node>path)
    //{
    //    if(root==null)
    //    return false;
    //    path.add(root);
    //    if(root.data==n)
    //    return true;
    //    boolean foundleft=getPath(root.left, n, path);
    //    boolean foundRight=getPath(root.right, n, path);
    //    if(foundleft || foundRight)
    //    return true;
    //    path.remove(path.size()-1);
    //    return false;
    //}
    //public static Node lca(Node root,int n1,int n2)//O(n)
    //{
    //    ArrayList<Node>path1=new ArrayList<>();
    //    ArrayList<Node>path2=new ArrayList<>();
    //    getPath(root,n1,path1);
    //    getPath(root,n2,path2);
    //    // calculating lca
    //    int i=0;
    //    for(;i<path1.size() && i<path2.size();i++)
    //    {
    //        if(path1.get(i)!=path2.get(i))
    //        break;
    //    }
    //    // last equal Node-> ith-1
    //    Node lca=path1.get(i-1);
    //    return lca;
    //}

    //Approach 2
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

        if(leftLca==null)
        return rightLca;

        return root;
    }
    public static Node lca(Node root,Node n1,Node n2)//O(n) S.C.->0
    {
        if(root==null)
        return null;
        if(root==n1 || root==n2)
        return root;
        Node left=lca(root.left, n1, n2);
        Node right=lca(root.right, n1, n2);
        if(left!=null && right!=null)
        return root;
        return left==null?right:left;
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
        int n1=4,n2=6;
        System.out.println(lca(root, n1, n2).data);
    }    
}