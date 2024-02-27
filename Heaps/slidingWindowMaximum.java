import java.util.*;
public class slidingWindowMaximum 
{
    static class Pair implements Comparable <Pair>
    {
        int num;
        int idx;
        public Pair(int n,int i)
        {
            this.num=n;
            this.idx=i;
        }
        @Override
        public int compareTo(Pair p2)
        {
            return p2.num-this.num;//descending order
        }
    }
    public static void main(String[] args)//O(n log(n)) 
    {
        int ar[]={1,3,-1,-3,5,3,6,7};
        int k=3;
        int res[]=new int[ar.length-k+1];
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        for(int i=0;i<k;i++)
        {
            pq.add(new Pair(ar[i],i));
        }
        res[0]=pq.peek().num;
        for(int i=k;i<ar.length;i++)
        {
            while(pq.size()>0 && pq.peek().idx<=(i-k))
            pq.remove();
            
            pq.add(new Pair(ar[i],i));
            res[i-k+1]=pq.peek().num;
        }
        //print result
        for(int i=0;i<res.length;i++)
        System.out.print(res[i]+" ");
    }
}
