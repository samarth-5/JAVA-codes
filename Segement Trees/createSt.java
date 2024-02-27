import java.util.*;
class createSt
{
    static int tree[];
    public static void init(int n)
    {
        tree=new int[4*n];
    }
    public static int buildSt(int ar[],int idx,int start,int end)
    {
        if(start==end)
        {
            tree[idx]=ar[start];
            return ar[start];
        }
        int mid=(start+end)/2;
        buildSt(ar, 2*idx+1, start, mid);//left subtree
        buildSt(ar, 2*idx+2, mid+1, end);//right subtree
        tree[idx]=tree[2*idx+1]+tree[2*idx+2];
        return tree[idx];
    }
    public static void main(String[] args) 
    {
        int ar[]={1,2,3,4,5,6,7,8};
        int n=ar.length;
        init(n);
        buildSt(ar,0,0,n-1);
        for(int i=0;i<tree.length;i++)
        System.out.print(tree[i]+" ");
    }
}