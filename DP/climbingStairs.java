import java.util.*;
public class climbingStairs 
{
    public static int countWaysRec(int n)//O(2^n)
    {
        if(n<0)
        return 0;
        if(n==0)
        return 1;
        return countWaysRec(n-1)+countWaysRec(n-2);
    }  
    public static int countWaysMemo(int n,int ar[])//O(n)
    {
        if(n<0)
        return 0;
        if(n==0)
        return 1;
        if(ar[n]!=-1)
        return ar[n];
        ar[n]=countWaysMemo(n-1, ar)+countWaysMemo(n-2, ar);
        return ar[n];
    } 
    public static int countWaysTabulation(int n)//O(n)
    {
        int dp[]=new int[n+1];
        dp[0]=1;
        for(int i=1;i<n+1;i++)
        {
            if(i==1)
            {
                dp[i]=dp[i-1];
            }
            else
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
    public static void main(String[] args) 
    {
        int n=5;
        //int ways=countWaysRec(n);
        //int ways=countWaysRec(n,ar);
        int ar[]=new int[n+1];
        Arrays.fill(ar,-1);
        //int ways=countWaysMemo(n, ar);
        int ways=countWaysTabulation(n);
        System.out.println(ways);
    } 
}