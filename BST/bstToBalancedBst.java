import java.util.*;
public class bstToBalancedBst 
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
    public static void getInorder(Node root,ArrayList<Integer> inorder)
    {
        if(root==null)
        return;
        getInorder(root.left, inorder);
        inorder.add(root.data);
        getInorder(root.right, inorder);
    }
    public static Node createBalancedBst(ArrayList<Integer> ar,int l,int h)//O(n)
    {
        if(l>h)
        return null;
        int mid=l+(h-l)/2;
        Node root=new Node(ar.get(mid));
        root.left=createBalancedBst(ar,l,mid-1);
        root.right=createBalancedBst(ar,mid+1,h);
        return root;
    }
    public static Node balanceBst(Node root)
    {
        //inOrder sequence
        ArrayList<Integer> inorder=new ArrayList<>();
        getInorder(root, inorder);

        //sorted inorder -> balanced bst
        root=createBalancedBst(inorder, 0, inorder.size()-1);
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
    public static void main(String[] args) {
        Node root=new Node(8);                 //             8
        root.left=new Node(6);                 //            / \                    8
        root.left.left=new Node(5);            //           6  10                 /  \
        root.left.left.left=new Node(3);       //          /    \      ->        5   11
        root.right=new Node(10);               //         5     11              / \  / \ 
        root.right.right=new Node(11);         //        /       \             3  6 10 12
        root.right.right.right=new Node(12);   //       3        12
        preOrder(root);
        System.out.println();
        root=balanceBst(root);
        preOrder(root);
    }    
}
