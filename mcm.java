import java.util.*;
class mcm
{
    //recursion
    public static int mult(int ar[],int i,int j)
    {
        if(i==j)
        return 0;
        int ans=Integer.MAX_VALUE;
        for(int k=i;k<=j-1;k++)
        {
            int cost1=mult(ar,i,k);
            int cost2=mult(ar,k+1,j);
            int cost3=ar[i-1]*ar[k]*ar[j];
            int finalCost=cost1+cost2+cost3;
            ans=Math.min(ans,finalCost);
        }
        return ans;
    }
    public static void main(String[] args) {
        int ar[]={1,2,3,4,3};
        int n=ar.length;
        System.out.println(mult(ar,1,n-1));
    }
}