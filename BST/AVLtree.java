public class AVLtree
{
    static class Node
    {
        int data,height;
        Node left,right;
        Node(int data)
        {
            this.data=data;
            height=1;
        }
    }
    public static Node root;
    public static int height(Node root)
    {
        if(root==null)
        return 0;
        return root.height;
    }
    static int max(int a,int b)
    {
        return (a>b)?a:b;
    }
    // Left rotate subtree rotated with x
    public static Node leftRotate(Node x)
    {
        Node y=x.right;//          x
        Node T2=y.left;//           \
        //Perform rotation           y  
        y.left=x;//                 /     
        x.right=T2;//              T2
        //Update heights
        x.height=max(height(x.left),height(x.right))+1;
        y.height=max(height(y.left),height(y.right))+1;
        //return new root
        return y;
    }
    // Right rotate subtree rooted with y
    public static Node rightRotate(Node y)
    {
        Node x=y.left;//            y
        Node T2=x.right;//         /
        //Perform rotation        x                                
        x.right=y;//               \
        y.left=T2;//               T2
        //Update heights
        y.height=max(height(y.left),height(y.right))+1;        
        x.height=max(height(x.left),height(x.right))+1;
        //return new root
        return x;
    }
    public static int getBalance(Node root)
    {
        if(root==null)
        return 0;
        return height(root.left)-height(root.right);
    }
    public static Node insert(Node root,int key)
    {
        if(root==null)
        return new Node(key);
        if(key<root.data)
        root.left=insert(root.left, key);
        else if(key>root.data)
        root.right=insert(root.right, key);
        else
        return root; //Duplicate keys not allowed

        //Update root height
        root.height=1+Math.max(height(root.left),height(root.right));
        //Get root's balance factor
        int bf=getBalance(root);

        //Left-left case
        if(bf>1 && key<root.left.data)
        return rightRotate(root);

        //Right-right case
        if(bf<-1 && key>root.right.data)
        return leftRotate(root);

        //Left-right case
        if(bf>1 && key>root.left.data)
        {
            root.left=leftRotate(root.left);
            return rightRotate(root);
        }

        //Right-left case
        if(bf<-1 && key<root.right.data)
        { 
            root.right=rightRotate(root.right);
            return leftRotate(root);
        }

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
        root=insert(root,10);
        root=insert(root,20);
        root=insert(root,30);
        root=insert(root,40);
        root=insert(root,50);
        root=insert(root,25);
        /*         AVL TREE
         *            30
         *           /  \
         *          20  40
         *         / \   \
         *        10 25  50
         */    
        preOrder(root);   
    }
}