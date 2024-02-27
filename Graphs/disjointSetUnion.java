import java.util.*;
class disjointSetUnion
{
    static int n=7;
    static int par[]=new int[n];
    static int rank[]=new int[n];
    public static void init()
    {
        for(int i=0;i<n;i++)
        {
            par[i]=i;//initializing parent with itself
        }
    }
    public static int find(int x)
    {
        if(x==par[x])
        return x;
        //return find(par[x]);
        //path-compression optimization(dp)
        //storing the updated parent
        return par[x]=find(par[x]);
    }
    public static void union(int a,int b)//O(4*k)->O(1)
    {
        int parA=find(a);
        int parB=find(b);
        if(rank[parA]==rank[parB])
        {
            //make anyone parent of other
            par[parB]=parA;//A is parent of B
            rank[parA]++;
        }
        else if(rank[parA]<rank[parB])
        {
            //rank will not be updated
            par[parA]=parB;
        }
        else
        {
            //rank will bot be updated
            par[parB]=parA;
        }
    }
    public static void main(String[] args) 
    {        
        init();
        System.out.println(find(3));
        union(1,3);
        System.out.println(find(3));
        union(2,4);
        union(3,6);
        union(1,4);
        System.out.println(find(6));
        System.out.println(find(4));
        union(1,5);
    }
}