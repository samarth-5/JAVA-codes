import java.util.*;
class targetSumSubset
{
    //tabulation
    //O(n*sum)
    public static boolean targetSum(int ar[],int sum)
    {
        int n=ar.length;
        boolean dp[][]=new boolean[n+1][sum+1];
        //initialization
        for(int i=0;i<n+1;i++)
        {
            dp[i][0]=true;
        }
        //code
        //i->array j->sum
        for(int i=1;i<n+1;i++)
        {
            for(int j=1;j<sum+1;j++)
            {
                int v=ar[i-1];
               //include
               if(v<=j && dp[i-1][j-v]==true) 
               dp[i][j]=true;
               //exclude
               else if(dp[i-1][j]==true)
               dp[i][j]=true;
            }
        }
        print(dp);
        return dp[n][sum];
    }
    public static void print(boolean dp[][])
    {
        for(int i=0;i<dp.length;i++)
        {
            for(int j=0;j<dp[0].length;j++)
            System.out.print(dp[i][j]+"\t");
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int ar[]={4,2,7,1,3};
        int sum=10;
        System.out.println(targetSum(ar, sum));
    }
}