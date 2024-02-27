import java.util.*;
class diameter
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
    //public static int height(Node root)
    //{
    //    if(root == null)
    //    return 0;
    //    int lh=height(root.left);
    //    int rh=height(root.right);
    //    return Math.max(lh,rh)+1;
    //}
    //Approach 1
    //public static int calcDiameter(Node root)//O(n^2)
    //{
    //    if(root==null)
    //    {
    //        return 0;
    //    }
    //    int lh=height(root.left);
    //    int rh=height(root.right);
    //    int ld=calcDiameter(root.left);
    //    int rd=calcDiameter(root.right);
    //    int selfD=lh+rh+1;
    //    return (int)Math.max(selfD,Math.max(ld,rd));
    //}

    //Approach 2
    static class Info
    {
        int diam,ht;
        public Info(int d,int h)
        {
            this.diam=d;
            this.ht=h;
        }
    }
    public static Info calcDiameter(Node root)//O(n)
    {
        if(root==null)
        return new Info(0,0);
        Info leftInfo=calcDiameter(root.left);
        Info rightInfo=calcDiameter(root.right);
        int selfD=(int)Math.max(Math.max(leftInfo.diam,rightInfo.diam),leftInfo.ht+rightInfo.ht+1);
        int selfHt=Math.max(leftInfo.ht,rightInfo.ht)+1;
        return new Info(selfD,selfHt);
    }
    public static void main(String[] args) {
        /*          1
                  /   \
                 2     3
                / \   / \
               4   5 6   7          
         */     
        Node root=new Node(1);
        root.left=new Node(2);
        root.right=new Node(3);
        root.left.left=new Node(4);
        root.left.right=new Node(5);    
        root.right.left=new Node(6);
        root.right.right=new Node(7);
        System.out.println("Diameter of tree : "+calcDiameter(root).diam);
    }
}