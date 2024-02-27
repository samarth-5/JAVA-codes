import java.util.*;
public class merge2Bst 
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
    public static void getInorder(Node root,ArrayList<Integer>ar)
    {
        if(root==null)
        return;
        getInorder(root.left, ar);
        ar.add(root.data);
        getInorder(root.right, ar);
    }
    public static Node mergeBST(Node root1,Node root2)
    {
        ArrayList<Integer>ar1=new ArrayList<>();
        getInorder(root1,ar1);
        ArrayList<Integer>ar2=new ArrayList<>();
        getInorder(root2,ar2);
        //merge
        int i=0,j=0;
        ArrayList<Integer>finalAr=new ArrayList<>();
        while(i<ar1.size() && j<ar2.size())
        {
            if(ar1.get(i)<=ar2.get(j))
            {
                finalAr.add(ar1.get(i));
                i++;
            }
            else
            {
                finalAr.add(ar2.get(j));
                j++;
            }
        }
        while(i<ar1.size())
        {
            finalAr.add(ar1.get(i));
            i++;
        }
        while(j<ar2.size())
        {
            finalAr.add(ar2.get(j));
            j++;
        }

        //build balanced bst from array
        Node root=createBST(finalAr,0,finalAr.size()-1);
        return root;
    }
    public static Node createBST(ArrayList<Integer>ar,int l,int h)
    {
        if(l>h)
        return null;
        int mid=l+(h-l)/2;
        Node root=new Node(ar.get(mid));
        root.left=createBST(ar, l, mid-1);
        root.right=createBST(ar, mid+1, h);
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
    public static void main(String[] args) 
    {        
        Node root1=new Node(2);       //     2
        root1.left=new Node(1);       //    / \
        root1.right=new Node(4);      //   1   4
        Node root2=new Node(9);       //     9
        root2.left=new Node(3);       //    / \
        root2.right=new Node(12);     //   3  12
        Node root=mergeBST(root1, root2);
        preOrder(root);
    }    
}
