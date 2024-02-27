import java.sql.Array;
import java.util.Arrays;

public class catalanNumber 
{
    //by recursion
    public static int catalan(int n)
    {
        if(n==0 || n==1)
        return 1;
        int ans=0;
        for(int i=0;i<n;i++)
        {
            ans+=catalan(i)*catalan(n-i-1);
        }
        return ans;
    }
    //by memoization
    public static int catalanMemo(int n,int dp[])
    {
        if(n==0 || n==1)
        return 1;
        if(dp[n]!=-1)
        return dp[n];
        int ans=0;
        for(int i=0;i<n;i++)
        {
            ans+=catalan(i)*catalan(n-i-1);
        }
        return dp[n]=ans;
    }
    //by tabulation
    public static int catalanTabu(int n)
    {
        int dp[]=new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<=n;i++)
        {
            for(int j=0;j<i;j++)
            dp[i]+=dp[j]*dp[i-j-1];
        }
        return dp[n];
    }
    public static void main(String[] args) {
        int dp[]=new int[30+1];
        Arrays.fill(dp,-1);
        System.out.println(catalanTabu(30));
    }
}