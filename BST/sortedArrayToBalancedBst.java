import java.util.*;
public class sortedArrayToBalancedBst 
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
    public static void preOrder(Node root)
    {
        if(root==null)
        return;
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }
    public static Node balanceBst(int ar[],int l,int h)//O(n)
    {
        if(l>h)
        return null;
        int mid=l+(h-l)/2;
        Node root=new Node(ar[mid]);
        root.left=balanceBst(ar,l,mid-1);
        root.right=balanceBst(ar,mid+1,h);
        return root;
    }
    public static void main(String[] args) {
        int ar[]={3,5,6,8,10,11,12};
        Node root=balanceBst(ar, 0, ar.length-1);
        preOrder(root);
    }
}
