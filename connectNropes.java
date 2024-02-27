import java.util.*;
class connectNropes
{
    public static int connect(int ar[])
    {
        Arrays.sort(ar);
        int cost=ar[0],finalCost=0;
        for(int i=1;i<ar.length;i++)
        {
            int r=ar[i];
            cost+=r;
            finalCost+=cost;
        }
        return finalCost;
    }
    public static void main(String[] args) {
        int ar[]={4,2,3,6};
        System.out.println(connect(ar));
    }
}